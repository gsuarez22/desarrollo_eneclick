package domain;

public class disponibilidad {

    String id_arbitro = "", dia = "", horaDesde = "", horaHasta = "";
    int horaMilD = 0, horaMilH = 0; 
    
    public void calcularHoraMil()
    {
        String hmd = "0", hmh = "0";

        hmd = horaDesde;
        hmd = hmd.substring(11,hmd.length());
        hmd = hmd.replace(":", "");
        hmd = hmd.substring(0,4);
        horaMilD = Integer.parseInt(hmd);
        
        hmh = horaHasta;
        hmh = hmh.substring(11,hmh.length());
        hmh = hmh.replace(":", "");
        hmh = hmh.substring(0,4);
        horaMilH = Integer.parseInt(hmh);
        
    }
    
}
