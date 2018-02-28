/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libroo;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author pau
 */
public class LibroTest {

    public LibroTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTitulo method, of class Libro.
     */
    @Test
    public void testGetTitulo() {
        System.out.println("getTitulo");
        Libro instance = new Libro("Java1", "Manolo", 1111, 1, 1);
        String expResult = "Java1";
        String result = instance.getTitulo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTitulo method, of class Libro.
     */
    @Test
    public void testSetTitulo() {
        System.out.println("setTitulo");
        String titulo = "El principito";
        Libro instance = new Libro();
        
        instance.setTitulo(titulo);
        String a = instance.getTitulo();
        assertEquals(a, titulo);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAutor method, of class Libro.
     */
    @Test
    public void testGetAutor() {
        System.out.println("getAutor");
        Libro instance = new Libro();
     
        
        String expResult = "Jesucristo";
        instance.setAutor(expResult);
        
        String result = instance.getAutor();
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAutor method, of class Libro.
     */
    @Test
    public void testSetAutor() {
        System.out.println("setAutor");
        String autor = "Jose";
        Libro instance = new Libro();
        instance.setAutor(autor);

        String a = instance.getAutor();
        assertEquals(a, autor);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIsbn method, of class Libro.
     */
    @Test
    public void testGetIsbn() {
        System.out.println("getIsbn");
        Libro instance = new Libro();

        int expResult = 4747;
        instance.setIsbn(expResult);
        int result = instance.getIsbn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIsbn method, of class Libro.
     */
    @Test
    public void testSetIsbn() {
        System.out.println("setIsbn");
        int isbn = 98;

        Libro instance = new Libro();
        instance.setIsbn(isbn);
        int esperado = instance.getIsbn();

        assertEquals(isbn, esperado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNum_ejem_pres method, of class Libro.
     */
    @Test
    public void testGetNum_ejem_pres() {
        System.out.println("getNum_ejem_pres");
        Libro instance = new Libro();
        int expResult = 3;
        instance.setNum_ejem_pres(expResult);
        int result = instance.getNum_ejem_pres();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setNum_ejem_pres method, of class Libro.
     */
    @Test
    public void testSetNum_ejem_pres() {
        System.out.println("setNum_ejem_pres");
        int num_ejem_pres = 0;
        Libro instance = new Libro();
        instance.setNum_ejem_pres(num_ejem_pres);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getNum_ejem_tot method, of class Libro.
     */
    @Test
    public void testGetNum_ejem_tot() {
        System.out.println("getNum_ejem_tot");

        Libro instance = new Libro();
        int expResult = 3;
        instance.setNum_ejem_tot(expResult);

        int result = instance.getNum_ejem_tot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setNum_ejem_tot method, of class Libro.
     */
    @Test
    public void testSetNum_ejem_tot() {
        System.out.println("setNum_ejem_tot");
        int num_ejem_tot = 0;
        Libro instance = new Libro();
        instance.setNum_ejem_tot(num_ejem_tot);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getNum_ejem_pres_glob method, of class Libro.
     */
    @Test
    public void testGetNum_ejem_pres_glob() {
        System.out.println("getNum_ejem_pres_glob");

        int expResult = 9;
        Libro.setNum_ejem_pres_glob(expResult);

        int result = Libro.getNum_ejem_pres_glob();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setNum_ejem_pres_glob method, of class Libro.
     */
    @Test
    public void testSetNum_ejem_pres_glob() {
        System.out.println("setNum_ejem_pres_glob");
        int num_ejem_pres_glob = 0;
        Libro.setNum_ejem_pres_glob(num_ejem_pres_glob);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getNum_ejem_tot_glob method, of class Libro.
     */
    @Test
    public void testGetNum_ejem_tot_glob() {
        System.out.println("getNum_ejem_tot_glob");

        int expResult = 9;
        Libro.setNum_ejem_tot_glob(expResult);
        int result = Libro.getNum_ejem_tot_glob();
        assertEquals(expResult, result);

        // fail("The test case is a prototype.");
    }

    /**
     * Test of setNum_ejem_tot_glob method, of class Libro.
     */
    @Test
    public void testSetNum_ejem_tot_glob() {
        System.out.println("setNum_ejem_tot_glob");
        int num_ejem_tot_glob = 0;
        Libro.setNum_ejem_tot_glob(num_ejem_tot_glob);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of prestar_Libro method, of class Libro.
     */
    @Ignore
    public void testPrestar_Libro() {
        System.out.println("prestar_Libro");
        Libro instance = new Libro();
        boolean expResult = false;
        boolean result = instance.prestar_Libro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of pedir_prestar_Libro method, of class Libro.
     */
    @Ignore
    public void testPedir_prestar_Libro() {
        System.out.println("pedir_prestar_Libro");
        ArrayList<Libro> p = null;
        Libro.pedir_prestar_Libro(p);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of devolver_Libro method, of class Libro.
     */
    @Ignore
    public void testDevolver_Libro() {
        System.out.println("devolver_Libro");
        Libro instance = new Libro();
        boolean expResult = false;
        boolean result = instance.devolver_Libro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of pedir_devolver_Libro method, of class Libro.
     */
    @Ignore
    public void testPedir_devolver_Libro() {
        System.out.println("pedir_devolver_Libro");
        ArrayList<Libro> p = null;
        Libro.pedir_devolver_Libro(p);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar_Libro method, of class Libro.
     */
    @Ignore
    public void testMostrar_Libro() {
        System.out.println("mostrar_Libro");
        Libro instance = new Libro();
        instance.mostrar_Libro();
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of pedir_mostrar_Libro method, of class Libro.
     */
    @Ignore
    public void testPedir_mostrar_Libro() {
        System.out.println("pedir_mostrar_Libro");
        ArrayList<Libro> p = null;
        Libro.pedir_mostrar_Libro(p);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of localizar_Libro method, of class Libro.
     */
    @Ignore
    public void testLocalizar_Libro() {
        System.out.println("localizar_Libro");
        ArrayList<Libro> p = null;
        Libro.localizar_Libro(p);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of crear_Libro method, of class Libro.
     */
    @Ignore
    public void testCrear_Libro() {
        System.out.println("crear_Libro");
        Libro expResult = null;
        Libro result = Libro.crear_Libro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

}
