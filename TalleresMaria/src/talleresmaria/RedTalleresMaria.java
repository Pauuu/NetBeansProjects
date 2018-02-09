/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleresmaria;

import java.util.ArrayList;
import java.util.Scanner;

public class RedTalleresMaria {

    private ArrayList<Cliente> clientes;
    private ArrayList<Coche> coches;
    private ArrayList<Taller> talleres;
    private String nombre;

    public RedTalleresMaria(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList();
        this.talleres = new ArrayList();
        this.coches = new ArrayList();
    }

    // Publics -----------------------------------------------------------------
    public boolean cambiarPropietarioCoche(String matricula, String dni) {

        // Pongo los mensajes porque si me devuelve false no sabre si es porque
        // la matricula esta mal o el dni etc...
        if (this.findCoche(matricula) == null) {
            System.out.println("No se ha encontrado ningún coche con matrícula "
                    + matricula + " registrado en esta red.");
            return false; // =============Coche NO encontrado =================>
        }

        if (this.findCliente(dni) == null) {
            System.out.println("No se ha encontrado ningún cliente con DNI "
                    + dni + " registrado en esta red.");
            return false; // ========= Cliente NO encontrado ==================>
        }

        if (this.findCliente(dni).findCoche(matricula) != null) {
            System.out.println("EL cliente con DNI " + dni
                    + " ya es el propietario del coche con matrícula " + matricula);
            return false; // == El comprador YA es el propietario del coche ===>
        }

        if (this.findCoche(matricula).getPropietario() == null) {
            System.out.println("Upssss, el coche no tiene propietario");
            return false; // ==================================================>
        }

        this.findCoche(matricula).getPropietario().removeCoche(matricula);
        this.findCliente(dni).addCoche(matricula);

        return true; // Coche comprado
    }

    public boolean crearCliente(String fAlta, String dni, String nombre, int telefono) {

        // Comprobar si ya existe otro cliente con el dni
        if (this.findCliente(dni) != null) {
            return false; // Ya existe un cliente con este dni ================>
        }

        // No existe el cliente así que lo creamos y lo añadimos a la lista
        Cliente cliente = new Cliente(this, dni, nombre, telefono);
        cliente.setFecha(fAlta);
        this.clientes.add(cliente);

        return true; // Cliente creado correctamente
    }

    public boolean crearCoche(Cliente cliente, int km, String color, String marca,
            String matricula, String modelo) {
        if (this.findCoche(matricula) != null) {
            return false; //====== Ya existe un coche con esta matrícula ======>
        }

        if (this.findCliente(cliente.getDni()) == null) {
            return false; //=========== El propietario NO existe ==============>
        }

        Coche coche = new Coche(this, km, color, marca, matricula, modelo);
        this.coches.add(coche);

        if (!cliente.addCoche(coche.getMatricula())) {
            System.out.println("La hemos cagado.............");
            return false;
        }

        return true;
    }

    public boolean crearTaller(int codigo, int telefono, String direccion, String nombre) {
        if (this.findTaller(codigo) != null) {
            return false;
        }
        Taller taller = new Taller(this, codigo, telefono, direccion, nombre);
        this.talleres.add(taller);

        return true;
    }

    public Coche findCoche(String matricula) {
        for (int i = 0; i < this.coches.size(); i++) {
            if (this.coches.get(i).getMatricula().equalsIgnoreCase(matricula)) {
                return this.coches.get(i); // ======= Encontrado ==============>
            }
        }

        return null; // Coche no encontrado
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean infoCliente(String dni) {
        if (this.findCliente(dni) == null) {
            System.out.println("El cliente con " + dni + " no se encuentra en nuestra base de datos");
            return false; // ========= Cliente NO encontrado ==================>
        }
        this.findCliente(dni).infoCliente();

        return true; // =========== Cliente encontrado ========================>
    }

    public boolean infoCoche(String matricula) {
        if (this.findCoche(matricula) == null) {
            System.out.println("El vehículo con matrícula " + matricula + " no se encuentra en nuestra base de datos");
            return false; // =========== Coche NO encontrado ==================>
        }
        this.findCoche(matricula).infoCoche();

        return true; // ============= Coche encontrado ========================>
    }

    public boolean infoTaller(int codigo) {
        if (this.findTaller(codigo) == null) {
            System.out.println("El taller con código " + codigo + " no se encuentra en nuestra base de datos");
            return false; // =========== Taller NO encontrado =================>
        }
        this.findTaller(codigo).infoTaller();

        return true;
    }

    public void reportClientes() {
        if (this.clientes.isEmpty()) {
            System.out.println("No se ha encontrado ningún cliente registrado en esta red.");
        } else {
            System.out.println("Red de talleres " + this.getNombre());
            System.out.println("--------------------");
            System.out.println("REGISTRO DE CLIENTES");
            System.out.println("--------------------");
            System.out.println("|DNI            |NOMBRE");

            for (int i = 0; i < (this.clientes.size()); i++) {
                System.out.println("|" + (this.clientes.get(i)).getDni() + "      |" + (this.clientes.get(i)).getNombre());
            }
        }
    }

    public void reportCoches() {
        if (this.coches.isEmpty()) {
            System.out.println("No se ha encontrado ningún coche registrado en esta red.");
        } else {
            System.out.println("Red de talleres " + this.getNombre());
            System.out.println("---------------------");
            System.out.println("REGISTRO DE VEHÍCULOS");
            System.out.println("---------------------");
            System.out.println("|MATRÍCULA       |DNI PROPIETARIO");
            for (int i = 0; i < (this.coches.size()); i++) {
                System.out.println("|" + (this.coches.get(i)).getMatricula() + "         |" + ((this.coches.get(i)).getPropietario()).getDni());
            }
        }
    }

    public void reportTalleres() {
        if (this.talleres.isEmpty()) {
            System.out.println("No se ha encontrado ningún taller en esta red.");
        } else {
            System.out.println("Red de talleres " + this.getNombre());
            System.out.println("--------------------");
            System.out.println("REGISTRO DE TALLERES");
            System.out.println("--------------------");
            System.out.println("|CODIGO    |NOMBRE");
            for (int i = 0; i < (this.clientes.size()); i++) {
                System.out.println("|" + (this.talleres.get(i)).getCodigo() + "       |" + (this.talleres.get(i)).getNombre());
            }
        }
    }

    // Privates ----------------------------------------------------------------
    private Cliente findCliente(String dni) {
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).getDni().equalsIgnoreCase(dni)) {
                return this.clientes.get(i); // ===== Cliente encontrado ======>
            }
        }

        return null; // Cliente no encontrado
    }

    private Taller findTaller(int codigo) {
        for (int i = 0; i < this.talleres.size(); i++) {
            if (this.talleres.get(i).getCodigo() == codigo) {
                return this.talleres.get(i); // ======= Encontrado ============>
            }
        }

        return null; // Taller no encontrado
    }

    // Main --------------------------------------------------------------------
    public static void main(String[] args) {
        Cliente c;
        Coche v;
        Taller t;
        RedTalleresMaria r;

        System.out.println("Creo una red de talleres, 2 talleres y 2 clientes, el 1º con 2 coches y otro con 1 coche");
        System.out.println("");

        // Creo una red de talleres
        r = new RedTalleresMaria("- 4 Ruedas -");

        // Creo dos clientes
        r.crearCliente("22/01/18", "99888777B", "Ana", 987654654);
        r.crearCliente("22/01/18", "45666777A", "Pepe", 123456123);

        // Creo los coches 1 y 2
        // El propietario es el cliente1
        r.crearCoche(r.findCliente("99888777B"), 77500, "azul", "VW", "ABC4567", "t3");
        r.crearCoche(r.findCliente("99888777B"), 15375, "negro", "Porsche", "MMN4567", "Carrera");

        // Creo el coche 3
        // El propietario es el cliente2        
        r.crearCoche(r.findCliente("45666777A"), 263700, "rojo", "Seat", "CDE4567", "Panda");

        // Creo dos talleres
        r.crearTaller(345, 345098098, "c/ del taller, 1", "Taller rapidito");
        r.crearTaller(500, 123123123, "c/ Talleres una y no más, s/n.", "Taller Tortuga TT");

        // Muestro un listado de los clientes de la red1
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Muestro un listado de los clientes de la red1");
        System.out.println("");
        r.reportClientes();
        System.out.println("");

        // Muestro un listado de los coches de la red1
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Muestro un listado de los coches de la red1");
        System.out.println("");
        r.reportCoches();
        System.out.println("");

        // Muestro un listado de los talleres de la red1
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Muestro un listado de los talleres de la red1");
        System.out.println("");
        r.reportTalleres();
        System.out.println("");

        // Consulto los datos de un cliente poninedo un DNI que no existe
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Consulto los datos de un cliente poninedo un DNI que no existe");
        System.out.println("");
        r.infoCliente("99888777HJKGHJGHJGB");
        System.out.println("");

        // Consulto los datos de un coche poniendo una matrícula que no existe
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Consulto los datos de un coche poniendo una matrícula que no existe");
        System.out.println("");
        r.infoCoche("CDJHKHJKHJKJHKE4567");
        System.out.println("");

        // Consulto los datos de un taller poniendo un código que no existe
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Consulto los datos de un taller poniendo un código que no existe");
        System.out.println("");
        r.infoTaller(07655);
        System.out.println("");

        // Consulto los datos de los dos clientes poniendo su DNI
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Consulto los datos los dos clientes poniendo su DNI");
        System.out.println("");
        r.infoCliente("99888777B");
        System.out.println("");
        System.out.println("");
        r.infoCliente("45666777A");
        System.out.println("");

        // Consulto los datos de los coches poniendo su matrícula
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Consulto los datos de los coches poniendo su matrícula");
        System.out.println("");
        r.infoCoche("MMN4567");
        System.out.println("");
        r.infoCoche("CDE4567");
        System.out.println("");
        r.infoCoche("ABC4567");
        System.out.println("");

        // Consulto los datos del taller2 poniendo su código
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Consulto los datos del taller2 poniendo su código");
        System.out.println("");
        r.infoTaller(500);
        System.out.println("");

        // Mando un coche al taller2, indicando su matrícula y la red de talleres del taller.
        // Me equivoco con la matrícula
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Mando un coche al taller2, indicando su matrícula y la red de talleres del taller.");
        System.out.println("// Me equivoco con la matrícula");
        System.out.println("");
        r.findTaller(500).repararCoche("MMN456777");
        System.out.println("");

        // Mando un coche al taller2 con datos correctos
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Mando un coche al taller2 con datos correctos");
        System.out.println("");
        r.findTaller(500).repararCoche("MMN4567");
        System.out.println("");

        // Consulto los datos del coche otra vez
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Consulto los datos del coche otra vez");
        System.out.println("");
        r.infoCoche("MMN4567");
        System.out.println("");

        // Consulto los datos del taller2 otra vez
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Consulto los datos del taller2 otra vez");
        System.out.println("");
        r.infoTaller(500);
        System.out.println("");

        // Consulto los datos del dueño del coche en reparación
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Consulto los datos del dueño del coche en reparación");
        System.out.println("");
        r.infoCliente("99888777B");
        System.out.println("");

        // Intento llevar a reparar un coche que ya está en reparación
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Intento llevar a reparar el mismo coche (que ya está en reparación)");
        System.out.println("");
        r.findTaller(500).repararCoche("MMN4567");
        System.out.println("");

        // Una vez reparado, el cliente recoge su coche del taller y se equivoca
        // dando una matrícula que no está en la base de datos
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Una vez reparado, el cliente recoge su coche del taller y se equivoca al dar la matrícula");
        System.out.println("// dando una matrícula que no está en la base de datos");
        System.out.println("");
        r.findTaller(500).devolverCoche("MMN456777777");
        System.out.println("");

        // dando la matrícula de un coche que sí está en la base de datos pero que  no está en reparación
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// dando la matrícula de un coche que sí está en la base de datos pero que no está en reparación");
        System.out.println("");
        r.findTaller(500).devolverCoche("CDE4567");
        System.out.println("");

        // Una vez reparado, el cliente recoge su coche del taller dando los
        // datos correctos
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Una vez reparado, el cliente recoge su coche del taller dando los datos correctos");
        System.out.println("");
        r.findTaller(500).devolverCoche("MMN4567");
        System.out.println("");

        // Consulto los datos del coche otra vez
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Consulto los datos del coche otra vez");
        System.out.println("");
        r.infoCoche("MMN4567");
        System.out.println("");

        // Consulto los datos del taller2 otra vez
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Consulto los datos del taller2 otra vez");
        System.out.println("");
        r.infoTaller(500);
        System.out.println("");

        // Consulto los datos del dueño del coche reparado
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Consulto los datos del dueño del coche reparado");
        System.out.println("");
        r.infoCliente("99888777B");
        System.out.println("");

        // El cliente1 compra un coche del cliente2
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// El cliente1 compra un coche del cliente2");
        System.out.println("// Pongo el DNI y la matrícula");
        System.out.println("// Me equivoco en el DNI del comprador");
        System.out.println("");
        r.cambiarPropietarioCoche("CDE4567", "9988877711111B");
        System.out.println("");
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Me equivoco en la matrícula del coche");
        System.out.println("");
        r.cambiarPropietarioCoche("4567", "99888777B");
        System.out.println("");
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// El cliente 1 pone la matrícula de un coche que ya es suyo");
        System.out.println("");
        r.cambiarPropietarioCoche("ABC4567", "99888777B");
        System.out.println("");
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Pongo los datos correctos");
        System.out.println("");
        r.cambiarPropietarioCoche("CDE4567", "99888777B");
        System.out.println("");

        // Consulto los datos de ambos clientes
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Consulto los datos de ambos clientes");
        System.out.println("");
        r.infoCliente("99888777B");
        System.out.println("");
        r.infoCliente("45666777A");
        System.out.println("");

        // Consulto los datos del coche
        System.out.println("_______________________________________________________________________________________________________");
        System.out.println("// Consulto los datos del coche");
        System.out.println("");
        r.infoCoche("CDE4567");
        System.out.println("");
    }

}
