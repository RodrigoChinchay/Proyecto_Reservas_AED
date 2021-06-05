import java.util.ArrayList;
import java.util.GregorianCalendar;
public class Registro {
    private ArrayList<Reservas> registrado = new ArrayList<Reservas>();
    private ArrayList<Reservas> comprobado = new ArrayList<Reservas>();
    private ArrayList<Reservas> cancelaciones = new ArrayList<Reservas>();
    
    public Registro(String[][] registrarData, String[][] comprobarData, String[][] cancelaciones, Local can){
        crearRegistro(registrarData, can);
        crearComprobado(comprobarData, can);
        crearCancelaciones(cancelaciones, can);
    }
    public void crearRegistro(String[][] checkInData, Local can){
        ArrayList<Canchas> rum;
        for(int i = 1; i< checkInData.length; i++){
            int number = Integer.parseInt(checkInData[i][0]);
            int count = 0;
            for(int z = 0; z< registrado.size(); z++){
                if(number == registrado.get(z).getNumero()){
                    count++;
                }
            }
            if(count == 0){
                if(checkInData[i][7].equals("Classic Single") || checkInData[i][7].equals("Classic Twin") || checkInData[i][7].equals("Classic Double")){
                    rum = can.getArray("3");
                }else if(checkInData[i][7].equals("Executie Double") || checkInData[i][7].equals("Executive Twin") || checkInData[i][7].equals("Executive Single")){
                    rum = can.getArray("4");
                }else{
                    rum = can.getArray("5");
                }
                String nombre = checkInData[i][1];
                boolean tipoReserva = Boolean.parseBoolean(checkInData[i][2]);
                String fechaDe = checkInData[i][3];
                int horas = Integer.parseInt(checkInData[i][5]);
                int Canchas = Integer.parseInt(checkInData[i][6]);
                String tipoCampo = checkInData[i][7];
                int adultos = Integer.parseInt(checkInData[i][8]);
                int menores = Integer.parseInt(checkInData[i][9]);
                double deposito = Double.parseDouble(checkInData[i][10]);
                Reservas res = new Reservas(nombre, fechaDe, tipoReserva, horas, tipoCampo, adultos, deposito, menores);
                int loop = 1;                
            }
        }
    }
    public void crearComprobado(String[][] checkOutData, Local can){
        ArrayList<Canchas> rum;
        for(int i = 1; i< checkOutData.length; i++){
            int number = Integer.parseInt(checkOutData[i][0]);
            int count = 0;
            for(int z = 0; z< comprobado.size(); z++){
                if(number == comprobado.get(z).getNumero()){
                    count++;
                }
            }
            if(count == 0){
                if(checkOutData[i][7].equals("Classic Single") || checkOutData[i][7].equals("Classic Twin") || checkOutData[i][7].equals("Classic Double")){
                    rum = can.getArray("3");
                }else if(checkOutData[i][7].equals("Executie Double") || checkOutData[i][7].equals("Executive Twin") || checkOutData[i][7].equals("Executive Single")){
                    rum = can.getArray("4");
                }else{
                    rum = can.getArray("5");
                }
                String nombre = checkOutData[i][1];
                boolean tipoReserva = Boolean.parseBoolean(checkOutData[i][2]);
                String fechaDe = checkOutData[i][3];
                int horas = Integer.parseInt(checkOutData[i][5]);
                int Cancha = Integer.parseInt(checkOutData[i][6]);
                String tipoCampo = checkOutData[i][7];
                int adultos = Integer.parseInt(checkOutData[i][8]);
                int menores = Integer.parseInt(checkOutData[i][9]);                
                double deposito = Double.parseDouble(checkOutData[i][10]);
                Reservas res = new Reservas(nombre, fechaDe, tipoReserva, horas, tipoCampo, adultos, deposito, menores);
                int loop = 1;
                double sevenYears = 220898664000.0;
                GregorianCalendar today = new GregorianCalendar();
                
            }
        }
    }
    public void crearCancelaciones(String[][] cancellationsData, Local can){
        ArrayList<Canchas> rum;
        for(int i = 1; i< cancellationsData.length; i++){
            int number = Integer.parseInt(cancellationsData[i][0]);
            int count = 0;
            for(int z = 0; z< cancelaciones.size(); z++){
                if(number == cancelaciones.get(z).getNumero()){
                    count++;
                }
            }
            if(count == 0){
                if(cancellationsData[i][7].equals("Classic Single") || cancellationsData[i][7].equals("Classic Twin") || cancellationsData[i][7].equals("Classic Double")){
                    rum = can.getArray("3");
                }else if(cancellationsData[i][7].equals("Executie Double") || cancellationsData[i][7].equals("Executive Twin") || cancellationsData[i][7].equals("Executive Single")){
                    rum = can.getArray("4");
                }else{
                    rum = can.getArray("5");
                }
                String nombre = cancellationsData[i][1];
                boolean tipoReserva = Boolean.parseBoolean(cancellationsData[i][2]);
                String fechaDe = cancellationsData[i][3];
                int horas = Integer.parseInt(cancellationsData[i][5]);               
                String tipoCampo = cancellationsData[i][6];
                int adultos = Integer.parseInt(cancellationsData[i][7]);
                int menores = Integer.parseInt(cancellationsData[i][8]);
                double deposito = Double.parseDouble(cancellationsData[i][9]);
                Reservas res = new Reservas(nombre, fechaDe, tipoReserva, horas, tipoCampo, adultos, deposito, menores);
                int loop = 1;
                double sevenYears = 220898664000.0;
                GregorianCalendar today = new GregorianCalendar();
                
                }
            }
        }
    public boolean crearRegistro(int num, DataReserva data){
        GregorianCalendar today = new GregorianCalendar();
        for(int i = 0; i < data.getList().size(); i++){
            if(data.getList().get(i).getNumero() == num){
                if(data.getList().get(i).getFechaDe().after(today)){
                }else{
                    registrado.add(data.getList().get(i));
                    data.getList().remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean crearComprobado(int num){
        for(int i = 0; i < this.registrado.size(); i++){
            if(this.registrado.get(i).getNumero() == num){
                    comprobado.add(this.registrado.get(i));
                    registrado.remove(i);
                    return true;
            }
        }
        return false;
    }
    public ArrayList<Reservas> getRegistrado(){
        return registrado;
    }
    public ArrayList<Reservas> getComprobado() {
        return comprobado;
    }
    public ArrayList<Reservas> getCancelaciones() {
        return cancelaciones;
    }
}
