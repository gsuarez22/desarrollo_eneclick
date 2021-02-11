/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import fubb.sys.DBSSH;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

/**
 *
 * @author sistemas
 */
public class operativaA 
{

    public ArrayList partidosxcanchaxdiaxtipo, n1, n2, d1, d2, senior, equipos, canchas, fechasT;
    
    //CARGA INICIAL DE ARBIRTROS Y PARTIDOS
    public void cargarDesdeLaBase(String desde, String hasta)
    {
        //Select id_arbitro, id_equipo from fubb.afinidades order by id_arbitro

        String url = "Select a.tope, a.id_arbitro, a.categoria, a.nota_anual, CONCAT(a.nombre, ' ', a.apellido) as nombreCompleto, d.fecha, d.hora_desde, d.hora_hasta " +
        "from fubb.arbitros a " +
        "LEFT JOIN fubb.disponibilidad d ON a.id_arbitro = d.id_arbitro " +
        "and d.fecha >= '" + desde + "' and d.fecha <= '" + hasta + "'"  +
        "order by a.categoria, a.nota_anual DESC, a.id_arbitro";          
        cargarArbitros(url);         
 
        url = "Select * from fubb.partidos where fecha_hora >= '" + desde + " 00:00:00' and fecha_hora <= '" + hasta + " 23:59:59' order by tipo, fecha_hora";                
        partidosxcanchaxdiaxtipo = new ArrayList();
        cargarPartidos(url);
        
        url = "Select af.id_arbitro, af.id_equipo as nombre, a.categoria, e.id_equipo as ide from fubb.afinidades af, fubb.arbitros a, fubb.equipos e where e.nombre = af.id_equipo and a.id_arbitro = af.id_arbitro order by id_arbitro";
        cargarAfninidades(url);
        
        url = "SELECT id_equipo, nombre FROM fubb.equipos";
        equipo e = new equipo();
        equipos = e.cargarEquipos(url);
        
        url = "SELECT id_cancha, nombre_cancha FROM fubb.canchas";
        cancha c = new cancha();
        canchas = c.cargarCanchas(url);
        //JOptionPane.showMessageDialog(null, partidosxcanchaxdiaxtipo.size());

    }
    
    private void cargarPartidos (String url)
    {
        //p.id_partido, p.fecha_hora, p.local, p.visitante, p.cancha, p.tv, r.id_recaudador, r.categoria, r.nomenclator
        
        ArrayList flag = new ArrayList();
          
        try
        {
            CachedRowSet lista = DBSSH.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();

            while(lista.next())
            { 
                partido unP = new partido();  
                unP.id_partido = lista.getString("id_partido");
                unP.fecha = lista.getString("fecha_hora");
                unP.local = lista.getString("local");
                unP.visitante = lista.getString("visitante");
                unP.cancha = lista.getString("cancha");
                unP.tv = lista.getString("tv");
                unP.titulo = lista.getString("nomenclator");
                unP.tipo = lista.getString("tipo");
                unP.arbitro1 = lista.getString("arbitro1");
                unP.arbitro2 = lista.getString("arbitro2");
                unP.arbitro3 = lista.getString("arbitro3");
                try{if(unP.tv == null){unP.tv = "";}}catch(Exception ex){unP.tv = "";}
                unP.afinarFechaHora();  
                cargarPartidoxCancha(unP);
            }
                    
        }
        catch(Exception ex)
        {
            
        }          
       
    }
    
    private void cargarPartidoxCancha(partido P)
    {
        int i = 0;
        boolean encontre = false;
        String dia = P.fecha.substring(0, 10);
        while (i < partidosxcanchaxdiaxtipo.size())
        {
            cancha unaC = (cancha) partidosxcanchaxdiaxtipo.get(i);
            if(unaC.id_cancha.equals(P.cancha) && unaC.dia.equals(dia) && unaC.tipo_torneo.equals(P.tipo))
            {
                encontre = true;
                unaC.partidosDelDia.add(P);
                partidosxcanchaxdiaxtipo.set(i, unaC);
                i = partidosxcanchaxdiaxtipo.size();
            }
            i++;
        }
        
        if(encontre == false)
        {
            cancha c = new cancha();
            c.dia = dia;
            c.tipo_torneo = P.tipo;
            c.id_cancha = P.cancha;
            c.partidosDelDia = new ArrayList();
            c.partidosDelDia.add(P);
            partidosxcanchaxdiaxtipo.add(c);
        }
        
    }
    
    public void cargarArbitros (String url)
    {
        //r.id_recaudador as id, r.nombre, r.apellido, r.categoria, a.id_equipo as equipo, 0 as cant
        ArrayList flag = new ArrayList();
        n1 = new ArrayList();   n2 = new ArrayList();     d1 = new ArrayList();    d2 = new ArrayList();   senior = new ArrayList();
        try
        {
            CachedRowSet lista = DBSSH.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
            lista.first();
            arbitro unA = new arbitro();
            unA.id = lista.getString("id_arbitro");
            unA.categoria = lista.getString("categoria");
            unA.nombreCompleto = lista.getString("nombreCompleto");
            unA.nota = lista.getString("nota_anual");
            unA.tope = Integer.parseInt(lista.getString("tope"));
            lista.beforeFirst();
            while(lista.next())
            {
                if(unA.id.equals(lista.getString("id_arbitro")) == false)
                {                    
                    if(unA.categoria.equals("N1")){n1.add(unA);}
                    if(unA.categoria.equals("N2")){n2.add(unA);}
                    if(unA.categoria.equals("D1")){d1.add(unA);}
                    if(unA.categoria.equals("D2")){d2.add(unA);}
                    if(unA.categoria.equals("SENIOR")){senior.add(unA);}
                    
                    unA = new arbitro();
                    unA.id = lista.getString("id_arbitro");
                    unA.categoria = lista.getString("categoria");
                    unA.nombreCompleto = lista.getString("nombreCompleto");
                    unA.nota = lista.getString("nota_anual");
                    unA.tope = Integer.parseInt(lista.getString("tope"));
                }
                
                try{disponibilidad d = new disponibilidad();
                d.dia = lista.getString("fecha");
                d.horaDesde = lista.getString("hora_desde").replace("00.0", "");
                d.horaHasta = lista.getString("hora_hasta").replace("00.0", "");
                d.calcularHoraMil();
                unA.disponibilidad.add(d);}catch(Exception ex){}
            }
            
            if(unA.categoria.equals("N1")){n1.add(unA);}
            if(unA.categoria.equals("N2")){n2.add(unA);}
            if(unA.categoria.equals("D1")){d1.add(unA);}
            if(unA.categoria.equals("D2")){d2.add(unA);}
            if(unA.categoria.equals("SENIOR")){senior.add(unA);}
        
        }
        catch(Exception ex)
        {
            
        }      
        
    }
    
    private void cargarAfninidades (String url)
    {
        try
        {
            CachedRowSet lista = DBSSH.Function(url);
            RowSetMetaData rsmd = (RowSetMetaData)lista.getMetaData();
     
            while(lista.next())
            {
                equipo e = new equipo();
                e.id_equipo = lista.getString(4);
                e.nombre = lista.getString(2);
                arbitro a = new arbitro();
                a.id = lista.getString("id_arbitro");
                a.categoria = lista.getString("categoria");
                
                if (a.categoria.equals("N1")){ cargarAfinidad (e, a, n1); }
                if (a.categoria.equals("N2")){ cargarAfinidad (e, a, n2); }
                if (a.categoria.equals("D1")){ cargarAfinidad (e, a, d1); }
                if (a.categoria.equals("D2")){ cargarAfinidad (e, a, d2); }
                if (a.categoria.equals("SENIOR")){ cargarAfinidad (e, a, senior); }
            }
        }
        catch(Exception ex)
        {
            
        }   
    }
    
    private void cargarAfinidad(equipo e, arbitro a, ArrayList lista)
    {
        int i = 0;
        
        while (i < lista.size())
        {
            arbitro unaC = (arbitro) lista.get(i);
            if(unaC.id.equals(a.id))
            {
                unaC.afinidades.add(e);
                lista.set(i, unaC);
                i = lista.size();
            }
            i++;
        }
        
    }
    
    
    
    
    
    //DESIGNACION
    private ArrayList fechas (String desde, String hasta)
    {
        ArrayList flag = new ArrayList();
        ArrayList flage = new ArrayList();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd"); 
        try
        {
            Date dia = formateador.parse(hasta);
            boolean sigo = true;
            int x = 0;
            while (sigo)
            {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dia); // Configuramos la fecha que se recibe
                calendar.add(Calendar.DAY_OF_YEAR, - x);
                Date agregar = calendar.getTime();
                String dia_agregar = formateador.format(agregar);
                if(dia_agregar.equals(desde) || x == 6)
                {
                    sigo = false;
                }                
                flage.add(dia_agregar);
                x++;
            }
            
            for(int i = flage.size() - 1;i>0;i--)
            {
                flag.add(flage.get(i));
            }
            flag.add(hasta);
        }
        catch(Exception ex)
        {
        
        }
        return flag;
        
    /*    ArrayList flag = new ArrayList();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd"); 
        try
        {
            Date dia = formateador.parse(desde);
            boolean sigo = true;
            int x = 0;
            while (sigo)
            {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dia); // Configuramos la fecha que se recibe
                calendar.add(Calendar.DAY_OF_YEAR, + x);
                Date agregar = calendar.getTime();
                String dia_agregar = formateador.format(agregar);
                if(dia_agregar.equals(hasta))
                {
                    sigo = false;
                }                
                flag.add(dia_agregar);
                x++;
            }
        }
        catch(Exception ex)
        {
        
        }
        return flag;*/
    }
    
    public void designar(String desde, String hasta)
    {
        //FUNCIONA
        
        ArrayList fecha = fechas(desde,hasta);
        fechasT = fecha;
        int i = 0;
        while(i < fecha.size())
        {
            String fec = fecha.get(i).toString();
            int x = 0;
            ArrayList orden = new ArrayList();
            orden.add(3); orden.add(2); 
            orden.add(4); 
            orden.add(1);
            
            while (x < orden.size())
            {
                int cantidad = 1;
                int valor = Integer.parseInt(orden.get(x).toString());
                //FORMATIVAS MASCULINOS            
                
                if (valor == 4){cantidad = 2;}

                for(int h=0; h<cantidad; h++){hacerDesignacion (n1, 1, valor, "FORMATIVAS MASCULINO", fec);}
                for(int h=0; h<cantidad; h++){hacerDesignacion (d1, 2, valor, "FORMATIVAS MASCULINO", fec);}
                for(int h=0; h<cantidad; h++){hacerDesignacion (n2, 1, valor, "FORMATIVAS MASCULINO", fec);}
                for(int h=0; h<cantidad; h++){hacerDesignacion (d2, 2, valor, "FORMATIVAS MASCULINO", fec);}

                //FORMATIVAS FEMENINAS
                for(int h=0; h<cantidad; h++){hacerDesignacion (d1, 1, valor, "FORMATIVAS FEMENINO", fec);}
                for(int h=0; h<cantidad; h++){hacerDesignacion (d2, 2, valor, "FORMATIVAS FEMENINO", fec);}
                for(int h=0; h<cantidad; h++){hacerDesignacion (n1, 1, valor, "FORMATIVAS FEMENINO", fec);}
                for(int h=0; h<cantidad; h++){hacerDesignacion (d1, 2, valor, "FORMATIVAS FEMENINO", fec);}
                
                x++;
            }
            i++;
        }
        String puntero = "hola";
    }
    
    private ArrayList darIdPartidos(int cantPartidos, int posicion, cancha c)
    {
        ArrayList flag = new ArrayList();
        
        if(cantPartidos != 4)
        {
            for(int x = 0;x <c.partidosDelDia.size(); x++)
            {
                partido p = (partido) c.partidosDelDia.get(x);
                flag.add(p.id_partido);
            }
        }
        else
        {
            int i = 0;
            int cuenta = 0;
            while (i < c.partidosDelDia.size())
            {
                if(flag.size() < 2)
                {
                    partido unP = (partido) c.partidosDelDia.get(i);
                    if(unP.arbitro1 == null){unP.arbitro1 = "";}
                    if(unP.arbitro2 == null){unP.arbitro2 = "";}
                    if(unP.arbitro3 == null){unP.arbitro3 = "";}

                    if (posicion == 1)
                    {
                        if(unP.arbitro1.equals(""))
                        {
                            cuenta++;
                            flag.add(unP.id_partido);
                        }
                    }
                    if (posicion == 2)
                    {
                        if(unP.arbitro2.equals(""))
                        {
                            cuenta++;
                            flag.add(unP.id_partido);
                        }
                    }
                    if (posicion == 3)
                    {
                        if(unP.arbitro3.equals(""))
                        {
                            cuenta++;
                            flag.add(unP.id_partido);
                        }
                    }
                    
                }
                i++;    
            }
        }
       
        return flag;
    }
    
    public void hacerDesignacion (ArrayList arbitros, int posicionArbitro, int cantPartidosCancha, String tipoTorneo, String fecha)
    {
        int i = 0;
        
        while (i < partidosxcanchaxdiaxtipo.size())
        {
            cancha c = (cancha) partidosxcanchaxdiaxtipo.get(i);

            ArrayList idPart = darIdPartidos(cantPartidosCancha, posicionArbitro, c);
            
            if(c.tipo_torneo.equals(tipoTorneo) && c.dia.equals(fecha) && c.partidosDelDia.size() == cantPartidosCancha)
            {
                arbitro unA = buscarArbitro(c, arbitros, idPart);
                int x = 0;
                if(unA.id.equals("") == false && unA.id.equals("0") == false)
                {
                    while (x < c.partidosDelDia.size())
                    {
                        partido unP = (partido) c.partidosDelDia.get(x);
                        
                        if (unA.estoyEnPartidos(unP, idPart))
                        {
                                if(unP.arbitro1 == null){unP.arbitro1 = "";}
                                if(unP.arbitro2 == null){unP.arbitro2 = "";}
                                if(unP.arbitro3 == null){unP.arbitro3 = "";}

                                if(unP.arbitro1.equals(unA.id) == false && unP.arbitro2.equals(unA.id) == false && unP.arbitro3.equals(unA.id) == false)
                                {
                                    if(posicionArbitro == 1 && unP.arbitro1.equals(""))
                                    {
                                        unP.arbitro1 = unA.id;
                                        c.partidosDelDia.set(x, unP);
                                    }
                                    if(posicionArbitro == 2 && unP.arbitro2.equals(""))
                                    {
                                        unP.arbitro2 = unA.id;
                                        c.partidosDelDia.set(x, unP);
                                    }
                                    if(posicionArbitro == 3 && unP.arbitro3.equals(""))
                                    {
                                        unP.arbitro3 = unA.id;
                                        c.partidosDelDia.set(x, unP);
                                    }
                                }
                        }
                        x++;
                    }
                }
            }
            i++;
        }
    }
    
    private arbitro buscarArbitro(cancha c, ArrayList arbitros, ArrayList idPart)
    {
        arbitro flag = new arbitro();
        int i = 0;
        while (i < arbitros.size())
        {
            arbitro a = (arbitro) arbitros.get(i);
            ArrayList cantidadArbitrados = listaDePartidosXArbitroXDia(a.id, c.dia);
            int cantPar = cantidadArbitrados.size();
            int partidoRestantes = cantPar + idPart.size() - a.tope;
                
            //Si la suma de los partidos + los que arbitrare son mayores al tope del arbitro la resta da positiva y ahi no puedo
            //SI la suma de los partidos + los que arbitrare - el tope da 0 o negativo
            if (partidoRestantes <= 0)
            {
                
                if(a.SoyAfin(c.partidosDelDia, idPart) == false)
                {
                    if(a.disponible(c.partidosDelDia,c.dia, idPart))
                    {
                        if(cantPar > 0)
                        {
                            if (a.partidosDelDiaNoChocanConCandidatos(cantidadArbitrados, c.partidosDelDia, idPart) == false)
                            {
                                flag = a;
                                i = arbitros.size();
                            }
                        }
                        else
                        {
                                flag = a;
                                i = arbitros.size();                        
                        }
                    }
                }
            }
            i++;
        }
        return flag;
    }
    
    //CARGAR TOTAL DE PARTIDOS POR ARBITRO PASADO POR PARAMETRO    
    public String cantidadDePartidosXArbitro (String id_arbitro)
    {
        int flag = 0;
        int i = 0;
        while (i < partidosxcanchaxdiaxtipo.size())
        {
            cancha unc = (cancha) partidosxcanchaxdiaxtipo.get(i);
            
            int x = 0;
            
            while (x < unc.partidosDelDia.size())
            {
                String id1 = "", id2 = "", id3 = "";
                partido unp = (partido) unc.partidosDelDia.get(x);
                
                try{id1 = unp.arbitro1;}catch (Exception ex){}
                try{id2 = unp.arbitro2;}catch (Exception ex){}
                try{id3 = unp.arbitro3;}catch (Exception ex){}
                
                if(id1 == null){id1 = "";}if(id2 == null){id2 = "";}if(id3 == null){id3 = "";}
                
                if(id1.equals(id_arbitro) || id2.equals(id_arbitro) || id3.equals(id_arbitro))
                {
                    flag++;
                }
                x++;
            }
            i++;            
        }
        return String.valueOf(flag);
    }
    
    //CARGAR TOTAL DE PARTIDOS POR ARBITRO PASADO POR PARAMETRO    
    public int cantidadDePartidosXArbitroXDia (String id_arbitro, String dia)
    {
        int flag = 0;
        int i = 0;
        while (i < partidosxcanchaxdiaxtipo.size())
        {
            cancha unc = (cancha) partidosxcanchaxdiaxtipo.get(i);
            if(unc.dia.equals(dia))
            {
                    
                int x = 0;

                while (x < unc.partidosDelDia.size())
                {
                    String id1 = "", id2 = "", id3 = "";
                    partido unp = (partido) unc.partidosDelDia.get(x);

                    try{id1 = unp.arbitro1;}catch (Exception ex){}
                    try{id2 = unp.arbitro2;}catch (Exception ex){}
                    try{id3 = unp.arbitro3;}catch (Exception ex){}

                    if(id1 == null){id1 = "";}if(id2 == null){id2 = "";}if(id3 == null){id3 = "";}

                    if(id1.equals(id_arbitro) || id2.equals(id_arbitro) || id3.equals(id_arbitro))
                    {
                        flag++;
                    }
                    x++;
                }
            }    
            i++;            
        }
        return flag;
    }
    
    public ArrayList listaDePartidosXArbitroXDia (String id_arbitro, String dia)
    {
        ArrayList flag = new ArrayList();
        int i = 0;
        while (i < partidosxcanchaxdiaxtipo.size())
        {
            cancha unc = (cancha) partidosxcanchaxdiaxtipo.get(i);
            if(unc.dia.equals(dia))
            {
                    
                int x = 0;

                while (x < unc.partidosDelDia.size())
                {
                    String id1 = "", id2 = "", id3 = "";
                    partido unp = (partido) unc.partidosDelDia.get(x);

                    try{id1 = unp.arbitro1;}catch (Exception ex){}
                    try{id2 = unp.arbitro2;}catch (Exception ex){}
                    try{id3 = unp.arbitro3;}catch (Exception ex){}

                    if(id1 == null){id1 = "";}if(id2 == null){id2 = "";}if(id3 == null){id3 = "";}

                    if(id1.equals(id_arbitro) || id2.equals(id_arbitro) || id3.equals(id_arbitro))
                    {
                        flag.add(unp);
                    }
                    x++;
                }
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
    
    private String darArbitro (ArrayList n, String id)
    {
        String flag = "";
        int i = 0;
        while(n.size() > i)
        {
            arbitro R = (arbitro) n.get(i);
            if (R.id.equals(id))
            {
                flag = R.nombreCompleto;
                i = n.size() + 1;                        
            }
            i++;
        }
        return flag;
    }
    
    public String miArbitro(String id)
    {
        String flag = "";
        flag = darArbitro(n1, id);
        if(flag.equals("")){flag = darArbitro(n2, id);}
        if(flag.equals("")){flag = darArbitro(d1, id);}
        if(flag.equals("")){flag = darArbitro(d2, id);}
        if(flag.equals("")){flag = darArbitro(senior, id);}
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
