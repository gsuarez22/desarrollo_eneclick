package domain;

import java.util.ArrayList;

public class arbitro 
{

    public ArrayList afinidades = new ArrayList();
    public ArrayList disponibilidad = new ArrayList();
    
    public String id = "", nombreCompleto = "", categoria = "", nota = ""; 
    int tope = 0;

    public boolean estoyEnPartidos (partido p, ArrayList idPart)
    {
        boolean flag = false;
        int i = 0;
        while( i < idPart.size())
        {
            String id = idPart.get(i).toString();
            if(id.equals(p.id_partido))
            {
                flag = true;
            }
            i++;
        }
        return flag;
    }
    
    public boolean SoyAfin(ArrayList partidos, ArrayList idPart) 
    {
        boolean flag = false;
        
        int i = 0;
        
        while (i < partidos.size())
        {
            partido p = (partido) partidos.get(i);
            
            if(estoyEnPartidos(p, idPart))
            {
                        int x = 0;

                        while (x < afinidades.size())
                        {
                            equipo e = (equipo) afinidades.get(x);
                            if (e.id_equipo.equals(p.local) || e.id_equipo.equals(p.visitante))
                            {
                                flag = true;
                                x = afinidades.size();
                                i = partidos.size();
                            }
                            x++;
                        }
            }
            i++;
        }
        
        return flag;
    }
    
    public boolean partidosDelDiaNoChocanConCandidatos(ArrayList cantidadArbitrados, ArrayList partidosDelDia, ArrayList idPart)
    {
        boolean flag = false;
         
        int i = 0;
        
        int horaminima = 2359;
        int horamaxima = 0;
        String cancha = "";
        
        while (i < partidosDelDia.size())
        {
            partido p = (partido) partidosDelDia.get(i);
            if(estoyEnPartidos(p, idPart))
            {
                        if (p.horaMil < horaminima){horaminima = p.horaMil;}
                        if (p.horaMil > horamaxima){horamaxima = p.horaMil;}
                        cancha = p.cancha;
            }
            i++;
        }
        
        int x = 0;
            
        while (x < cantidadArbitrados.size())
        {
            partido e = (partido) cantidadArbitrados.get(x);
            if (e.cancha.equals(cancha) == false)
            {
                if(e.horaMil >= horaminima - 3000 || e.horaMil <= horamaxima + 3000)
                {
                    flag = true;
                    x = cantidadArbitrados.size();                    
                }                
            }
            x++;
        }
                
        return flag;
    }
    
    public boolean disponible(ArrayList partidos, String dia, ArrayList idPart) 
    {
        boolean flag = false;
        
        int i = 0;
        
        int horaminima = 2359;
        int horamaxima = 0;
        
        while (i < partidos.size())
        {
            partido p = (partido) partidos.get(i);
            
            if(estoyEnPartidos(p, idPart))
            {
                    if (p.horaMil < horaminima){horaminima = p.horaMil;}
                    if (p.horaMil > horamaxima){horamaxima = p.horaMil;}
            }        
            i++;
        }
        
        int x = 0;
            
        while (x < disponibilidad.size())
        {
            disponibilidad e = (disponibilidad) disponibilidad.get(x);
            if (e.dia.equals(dia))
            {
                if(e.horaMilD <= horaminima && e.horaMilH >= horamaxima)
                {
                    flag = true;
                    x = disponibilidad.size();                    
                }                
            }
            x++;
        }

        return flag;
    }
    
}
