
package domain;

import fubb.sys.DBSSH;
import java.util.ArrayList;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;

public class operativaR 
{
    
    public ArrayList partidos, recaudadores, equipos, canchas;
     
    //PAQUETE DE CARGA DE INFORMACION DESDE LA BASE DE DATOS A LOS ARRAYS
    public void cargarDesdeLaBase(String desde, String hasta)
    {
        String url = "SELECT r.id_recaudador as id, r.nombre, r.apellido, r.categoria, a.id_equipo as equipo, 0 as cant FROM fubb.recaudadores r left join fubb.afinidades_recaudadores a on a.id_recaudador = r.id_recaudador " +
                     "UNION " +
                     "SELECT r.id_recaudador as id, r.nombre, r.apellido, r.categoria, '0' as equipo, count(r.id_recaudador) AS cant FROM fubb.recaudadores r, fubb.partidos pa, fubb.partidos_recaudadores p " + 
                     "where p.id_recaudador = r.id_recaudador and pa.id_partido = p.id_partido and pa.fecha_hora >= '" + desde + " 00:00:00' and pa.fecha_hora <= '" + hasta + " 23:59:59' and (pa.nomenclator like '%METRO%' or pa.nomenclator like '%LUB%') " + 
                     "group by r.id_recaudador " +
                     "order by id";
          
        recaudadores = cargarRecaudadores(url);
          
        url = "SELECT p.id_partido, p.fecha_hora, p.local, p.visitante, p.cancha, p.tv, r.id_recaudador, p.nomenclator  " +
                    "from fubb.partidos p " +
                    "left join fubb.partidos_recaudadores r ON p.id_partido = r.id_partido " +
                    "where (p.nomenclator like '%LUB%' or p.nomenclator like '%METRO%') and p.fecha_hora <= '" + hasta + " 23:59:59'  and p.fecha_hora >= '" + desde + " 00:00:00' " +
                    "order by p.nomenclator DESC, p.fecha_hora DESC";                
        partidos = cargarPartidos(url);
        cargarCategoria();

        url = "SELECT id_equipo, nombre FROM fubb.equipos";
        equipo e = new equipo();
        equipos = e.cargarEquipos(url);
        
        url = "SELECT id_cancha, nombre_cancha FROM fubb.canchas";
        cancha c = new cancha();
        canchas = c.cargarCanchas(url);
        
        //String test = "";
    }
    
    public void cargarCategoria()
    {
        for(int i = 0; i < partidos.size(); i++)
        {
            partido p = (partido) partidos.get(i);
            
            for(int x = 0; x < p.recaudadores.size(); x++)
            {
                recaudador r = (recaudador) p.recaudadores.get(x);
                int z = 0;
                while (recaudadores.size() > z)
                {
                    recaudador unR = (recaudador) recaudadores.get(z);
                    if(unR.id_recaudador.equals(r.id_recaudador))
                    {
                        r.categoria = unR.categoria;
                        z = z + recaudadores.size();                        
                    }
                    z++;
                }
                p.recaudadores.set(x, r);
            }
        }
    }
      
    public ArrayList cargarRecaudadores (String url)
    {
        //r.id_recaudador as id, r.nombre, r.apellido, r.categoria, a.id_equipo as equipo, 0 as cant
        ArrayList flag = new ArrayList();
          
        try
        {
            CachedRowSet lista = DBSSH.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            lista.first();
            recaudador unR = new recaudador();
            unR.id_recaudador = lista.getString("id");
            lista.beforeFirst();
            while(lista.next())
            {
                if(unR.id_recaudador.equals(lista.getString("id")) == false)
                {                    
                    flag.add(unR);
                    unR = new recaudador();
                }
                unR.id_recaudador = lista.getString("id");
                unR.nombre = lista.getString("nombre");
                unR.apellido = lista.getString("apellido");
                unR.categoria = lista.getString("categoria");
                if (lista.getString("cant").equals("0") == false)
                {
                    unR.cantidad = Integer.parseInt(lista.getString("cant"));
                }
                
                try
                {
                    if(lista.getString("equipo") != null && lista.getString("equipo").equals("0") == false)
                    {
                        unR.afinidades.add(lista.getString("equipo"));
                    }
                }
                catch(Exception ex)
                {
                
                }
                
            }
            flag.add(unR);
        }
        catch(Exception ex)
        {
            
        }
          
        return flag;

    }
    
    public ArrayList cargarPartidos (String url)
    {
        //p.id_partido, p.fecha_hora, p.local, p.visitante, p.cancha, p.tv, r.id_recaudador, r.categoria, r.nomenclator
        
        ArrayList flag = new ArrayList();
          
        try
        {
            CachedRowSet lista = DBSSH.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            partido unP = new partido();  
            lista.first();
            unP.id_partido = lista.getString("id_partido");
            unP.fecha = lista.getString("fecha_hora");
            unP.local = lista.getString("local");
            unP.visitante = lista.getString("visitante");
            unP.cancha = lista.getString("cancha");
            unP.tv = lista.getString("tv");
            unP.titulo = lista.getString("nomenclator");
            try{if(unP.tv == null){unP.tv = "";}}catch(Exception ex){unP.tv = "";}
            lista.beforeFirst();
            while(lista.next())
            { 
                if(unP.id_partido.equals(lista.getString("id_partido")))
                {
                    recaudador unR = new recaudador();
                    if(lista.getString("id_recaudador") != null)
                    {
                        unR.id_recaudador = lista.getString("id_recaudador");
                        unP.recaudadores.add(unR);
                    }
                }
                else
                {
                    flag.add(unP);
                    unP = new partido();
                    unP.id_partido = lista.getString("id_partido");
                    unP.fecha = lista.getString("fecha_hora");
                    unP.local = lista.getString("local");
                    unP.visitante = lista.getString("visitante");
                    unP.cancha = lista.getString("cancha");
                    unP.tv = lista.getString("tv");
                    unP.titulo = lista.getString("nomenclator");
                
                    recaudador unR = new recaudador();
                    if(lista.getString("id_recaudador") != null)
                    {
                        unR.id_recaudador = lista.getString("id_recaudador");
                        unP.recaudadores.add(unR);
                    }
                }
            }
            flag.add(unP);
                    
        }
        catch(Exception ex)
        {
            
        }
          
        return flag;

    }

    
    //PAQUETE DE METODOS Y FUNCIONES QUE DEFINEN LA DESIGNACION
    
    //ARMA LAS CANTIDADES QUE NECESITA DE CADA RECAUDADOR
    public void AsignarPartidos()
    {
        try
        {
            int i = 0;
            while (i < partidos.size())
            {
                partido unP = (partido) partidos.get(i);
                String tv = "";
                try{if(unP.tv != null){tv = unP.tv;}}catch(Exception ex){unP.tv = "";}
                if (tv.equals("TV"))
                {
                    asignarRecaudadores ("PORTERO", 5, unP, "TV");
                    asignarRecaudadores ("BOLETERO", 1, unP, "TV");
                    asignarRecaudadores ("ALTERNO", 1, unP, "TV");
                    asignarRecaudadores ("FISCAL", 1, unP, "TV");
                }
                else
                {
                    asignarRecaudadores ("PORTERO", 4, unP, "");
                    asignarRecaudadores ("BOLETERO", 1, unP, "");
                    asignarRecaudadores ("ALTERNO", 1, unP, "");
                    asignarRecaudadores ("FISCAL", 1, unP, "");
                }
                i++;            
            }
        }
        catch(Exception ex){}
    }
    
    //ASIGNA SEGUN AsignarPartidos LE VA SOLICITANDO
    public void asignarRecaudadores (String categoria, int cantidad, partido P, String tv)
    {
        int cantidadDelPartido = cantidadPorCategoria (categoria, P);
        cantidad = cantidad - cantidadDelPartido;
        
        while (cantidad > 0)
        {
            String idRecaudador = darElQueTieneMenos(categoria, P, tv);
            if(idRecaudador.equals("0") == false)
            {
                recaudador R = new recaudador();
                R.id_recaudador = idRecaudador;
                R.categoria = categoria; 
                P.recaudadores.add(R);
                cantidad--;
            }
            else
            {
                cantidad--;
            }
        }
        
    }
    
    //CHEQUEA LA CATEGORIA DE UN RECAUDADOR EN LA LISTA DE RECAUDADORES
    public String miCategoria(String id)
    {
        String flag = "";
        int i = 0;
        while(recaudadores.size() > i)
        {
            recaudador R = (recaudador) recaudadores.get(i);
            if (R.id_recaudador.equals(id))
            {
                flag = R.categoria;
                i = recaudadores.size() + 1;                        
            }
            i++;
        }
        return flag;
    }
   
    //DETERMINA CUANTOS RECAUDADORES POR CATEGORIA TIENE UN PARTIDO
    public int cantidadPorCategoria (String categoria, partido P)
    {
        int flag = 0;
        int i = 0;
        
        while (P.recaudadores.size() > i)
        {
            recaudador Reca = (recaudador) P.recaudadores.get(i);
            String idRecaudador = Reca.id_recaudador;
            if (miCategoria(idRecaudador).equals(categoria) || miCategoria(idRecaudador).equals("TEST"))
            {
                flag++;
            }
            i++;
        }
        return flag;
    }

    //BUSCA POR CATERGORIA EL RECAUDADOR CON MENOS PARTIDOS
    public String darElQueTieneMenos (String categoria, partido P, String tv)
    {
        int i = 0;
        String flag = "0";
        int cantidad = 1000;
        int posicion = 0;
        
        while (recaudadores.size() > i)
        {
            recaudador R = (recaudador) recaudadores.get(i);
            if(R.categoria.equals(categoria))
            {
                if(R.cantidad < cantidad)
                {
                    if(puedoIr(P, R, tv))
                    {
                        flag = R.id_recaudador;
                        cantidad = R.cantidad;
                        posicion = i;
                    }
                }
            }
            i++;
        }
        
        if(flag.equals("0") == false)
        {
            recaudador R = (recaudador) recaudadores.get(posicion);
            R.cantidad++;
            //R.categoria = categoria;
            recaudadores.set(posicion, R);
        }
        
        return flag;
    }
    
    //CHEQUEA SI TIENE AFINIDAD
    public boolean SoyAfin(recaudador R, partido P)
    {
        boolean flag = false;
        int i = 0;
        while (R.afinidades.size() > i)
        {
            String equipo = (String) R.afinidades.get(i);
            if (equipo.equals(P.cancha) || equipo.equals(P.local) || equipo.equals(P.visitante))
            {
                flag = true;
                i = i + R.afinidades.size(); 
            }
            i++;
        }
        return flag;
    }
    
    //EVALUA SI EL RECAUDADOR YA NO ESTA EN OTRO PARTIDO A LA MISMA HORA O EN EL MISMO PARTIDO QUE SE PASA
    public boolean puedoIr (partido P, recaudador R, String tv)
    {
        int encontre = 0;
        boolean flag;
        int i = 0;
        while (partidos.size() > i)
        {
            partido lista = (partido) partidos.get(i);
            
            if(SoyAfin(R,lista) == false)
            {
                flag = tenesEsteRecaudador(R, lista);
                if (flag)
                {
                    String fec1 = lista.fecha.substring(0,10);
                    String fec2 = P.fecha.substring(0,10);
                    if(fec1.equals(fec2))
                    {
                        encontre = 1;
                        i = i + partidos.size();
                    }
                }
            }
            i++;
        }
        
        if(encontre == 1){flag = false;} else {flag = true;}
        return flag;
    }
    
    //DETERMINA SI EL RECAUDADOR ESTA EN EL PARTIDO QUE SE ENVIA
    public boolean tenesEsteRecaudador(recaudador R, partido P)
    {
        boolean flag = false;
        int i = 0;
        while (P.recaudadores.size() > i)
        {
            recaudador lista = (recaudador) P.recaudadores.get(i);
            if(lista.id_recaudador.equals(R.id_recaudador))
            {
                flag = true;
                i = P.recaudadores.size() + 1;
            }
            i++;
        }
        
        return flag;
    }
    
    
    
    
    
    
    
 //OBTIENE EL NOMBRE DE UNA CANCHA EN LA LISTA DE CANCHAS
    public String miCancha(String id)
    {
        String flag = "";
        int i = 0;
        while(canchas.size() > i)
        {
            cancha R = (cancha) canchas.get(i);
            if (R.id_cancha.equals(id))
            {
                flag = R.nombre_cancha;
                i = canchas.size() + 1;                        
            }
            i++;
        }
        return flag;
    }
    
        //OBTIENE EL NOMBRE DE UNA CANCHA EN LA LISTA DE CANCHAS
    public String miEquipo(String id)
    {
        String flag = "";
        int i = 0;
        while(equipos.size() > i)
        {
            equipo R = (equipo) equipos.get(i);
            if (R.id_equipo.equals(id))
            {
                flag = R.nombre;
                i = equipos.size() + 1;                        
            }
            i++;
        }
        return flag;
    }
    
}
