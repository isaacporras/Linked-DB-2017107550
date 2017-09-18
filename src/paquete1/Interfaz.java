package paquete1;

import apple.laf.JRSUIUtils;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.simple.JSONObject;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.*;
import javafx.scene.control.*;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import sun.swing.SwingUtilities2;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.text.Font;

import javax.print.DocFlavor;
import javax.swing.*;

public class Interfaz extends Application {
    private File file;
    private ImageView imagenView;
    private Image imagen;
    Stage ventana;
    BorderPane canvas1;
    Pane canvas2;
    TreeView<String> arbol;
    TreeItem<String> item, root, item2, item3;
    StackPane paraArbol;
    Boolean title;
    Scene ponerNombreJSON;
    public String menu_botton_selected;
    int cuenta = 1;
    private boolean isRightClick;

    Store listasStore = new Store();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage ventanaPrimaria) throws Exception {
        // SE CREA LA VENTANA GRANDE//


        ventana = ventanaPrimaria;
        ventana.setTitle("Base de Datos");


        // CREAR - PEDAZO/FILE - DE MENU //


        Menu crear_store_JSON = new Menu("Crear..");
        MenuItem opcion_crear_json = new MenuItem("JSON Store");
        opcion_crear_json.setOnAction(e -> deplejarVentanaNombreJSON());
        crear_store_JSON.getItems().add(opcion_crear_json);


        Menu File = new Menu("File");
        File.getItems().add(new MenuItem("Close"));


        // SE CREA LA BARRA ENTERA DEL MENU//


        MenuBar barra = new MenuBar();
        barra.getMenus().addAll(crear_store_JSON);
        barra.getMenus().addAll(File);
        canvas1 = new BorderPane();
        canvas1.setTop(barra);

        root = new TreeItem<>("ROOT");
        root.setExpanded(true);
        arbol = new TreeView<>(root);
        arbol.setShowRoot(false);

        canvas1.setLeft(arbol);

        //CREAR LA VENTANA PARA METER DATOS JSONSTORE//


        Scene escena = new Scene(canvas1, 700, 600);
        ventana.setScene(escena);
        ventana.show();
    }

    //FUNCION A LA QUE VA EL EVENTO DE CREAR JSON //


    public void crearElItem(String nombre) {
        item = armarItemArbol(nombre);
    }

    // CREA UN ROOT/JSON STORE O CREA UN ELEMENTO NO ROOT //

    public static void display(){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Error!");
        window.setMinWidth(250);
        window.setMinHeight(50);

        Label label = new Label();
        label.setText("No puede dejar espacios en blanco");
        Button deleteButton = new Button("OK");
        deleteButton.setLayoutX(90);
        deleteButton.setLayoutY(20);
        deleteButton.setOnAction(e-> window.close());

        Pane layout = new Pane();
        layout.getChildren().addAll(label,deleteButton);


        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }

    public TreeItem<String> armarHijoArbol(TreeItem<String> padre, String nombre) {
//        System.out.println("EL PADRE ES " + padre.getParent().getValue());
//        System.out.println(padre.toString());
//        System.out.println(padre.getParent().toString());

//        Documentos documentos1 = new Documentos();
//        Objetos objetojson = new Objetos();
//        System.out.println(item2.getParent());


        item3 = new TreeItem<>(nombre);
        item3.setExpanded(true);
        padre.getChildren().add(item3);


//        listasStore.buscar_por_nombre(padre.getValue()).setDato(documentos1);
//        documentos1.ingresarDato(objetojson);
//        System.out.println("La lista de JSON Stores es: ");
//        System.out.println();
//        listasStore.imprimir_por_nombre();
//        System.out.println("Lista de Documentos:");
//        documentos1.imprimir();


        return item3;
    }

    //  DOCUMENTO VENTANA ///

    public TreeItem<String> armarItemArbol(String nombre) {

        listasStore.insertar(null, nombre);

        item2 = new TreeItem<String>(nombre);

        {

            // instantiate the root context menu

            ContextMenu rootContextMenu = ContextMenuBuilder.create().items(


                    MenuItemBuilder.create().text("Agregar Documento").onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent arg0) {

                            desplejarVentana_Documento_desde_el_arbol(arbol.getSelectionModel().selectedItemProperty().get(), 1, arbol.getSelectionModel().selectedItemProperty().get());


                        }
                    }).build(),


                    MenuItemBuilder.create().text("Agregar Objeto JSON").onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent arg0) {
                            System.out.println(arbol.getSelectionModel().selectedItemProperty().getValue().toString());
                            desplejarVentana_Documento_desde_el_arbol(arbol.getSelectionModel().selectedItemProperty().get(), 2, arbol.getSelectionModel().selectedItemProperty().get());


                        }
                    }).build(),

                    MenuItemBuilder.create().text("Mostrar Objetos en Memoria").onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent arg0) {

//                            mostrar_objetos_en_memoria(arbol.getSelectionModel().selectedItemProperty().get(), arbol.getSelectionModel().selectedItemProperty().get());
                            Tabla(arbol.getSelectionModel().selectedItemProperty().get());
                        }
                    }).build(),


                    MenuItemBuilder.create().text("Eliminar todods los Objeto JSON").onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent arg0) {

                            listasStore.buscar_por_nombre(arbol.getSelectionModel().selectedItemProperty().get().getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(arbol.getSelectionModel().selectedItemProperty().get().getValue()).getDato_Documento().eliminar_todos_los_Objetos();

                        }
                    }).build(),
                    MenuItemBuilder.create().text("Eliminar Objeto por Llave").onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent arg0) {

                            eliminar_json_por_llave();
                        }
                    }).build(),
                    MenuItemBuilder.create().text("Actualizar Objetos").onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent arg0) {
                            System.out.println("Menu Item Clicked!");
                        }
                    }).build())


                    .build();

            arbol.setContextMenu(rootContextMenu);
            root.setExpanded(true);
            item2.setExpanded(false);
            root.getChildren().add(item2);
        }


        System.out.println("La lista de JSON Stores es: ");
        listasStore.imprimir_por_nombre();


        return item2;
    }

    public void desplejarVentana_Documento_desde_el_arbol(TreeItem<String> padre_seleccionado, int nivel, TreeItem<String> item_seleccionado) {


        Stage ventana_documento = new Stage();

        ventana_documento.initModality(Modality.APPLICATION_MODAL);
        ventana_documento.setTitle("Creando Documento...");


        // imagenes de la ventana //

        File file3 = new File("/Users/IsaacPorras/Downloads/Progra1/src/paquete1/img/Nombre_documento_img.png");
        String localUrl1 = file3.toURI().toString();
        Image image_documento_palabra = new Image(localUrl1);
        ImageView imageView_documento_palabra = new ImageView(image_documento_palabra);
        imageView_documento_palabra.setLayoutX(20);
        imageView_documento_palabra.setLayoutY(20);

        File file2 = new File("/Users/IsaacPorras/Downloads/Progra1/src/paquete1/img/Documento_img.jpg");
        String localUrl2 = file2.toURI().toString();
        Image image_documento = new Image(localUrl2);
        ImageView imageView_documento = new ImageView(image_documento);
        imageView_documento.setLayoutX(350);
        imageView_documento.setLayoutY(150);


        // Nombre del Documento  //

        Label Nombre_Atributo = new Label("Nombre:");
        Nombre_Atributo.setLayoutX(20);
        Nombre_Atributo.setLayoutY(200);

        TextField text_atributo_nombre = new TextField();
        text_atributo_nombre.setLayoutX(130);
        text_atributo_nombre.setLayoutY(195);
        text_atributo_nombre.minWidth(60);


        //Tipo de atributo //


        Label Tipo_del_atributo = new Label("Tipo del Atributo:");
        Tipo_del_atributo.setLayoutX(15);
        Tipo_del_atributo.setLayoutY(250);

//        TextField text_atributo_tipo = new TextField();

//        text_atributo_tipo.setLayoutX(130);
//        text_atributo_tipo.setLayoutY(245);
//        text_atributo_tipo.minWidth(60);

        // Tipo Especial //

        Label tipo_especial_atributo = new Label("Tipo especial:");
        tipo_especial_atributo.setLayoutX(20);
        tipo_especial_atributo.setLayoutY(300);

        TextField text_tipo_especial_atributo = new TextField();
        text_tipo_especial_atributo.setLayoutX(130);
        text_tipo_especial_atributo.setLayoutY(295);
        text_tipo_especial_atributo.minWidth(60);

        //Requerido o No requerido //

        MenuItem menuItemint = new MenuItem("Int");
        menuItemint.setOnAction(e-> {
            menu_botton_selected = "int";});
        MenuItem menuItemfloat = new MenuItem("Float");
        menuItemfloat.setOnAction(e->{
            menu_botton_selected = "float";
        });
        MenuItem menuItemcadena = new MenuItem("Cadena");
        menuItemcadena.setOnAction(e->{
            menu_botton_selected = "cadena";
        });
        MenuItem menuItemfecha_hora = new MenuItem("Fecha - Hora");
        menuItemfecha_hora.setOnAction(e->{
            menu_botton_selected = "fecha-hora";
        });

        MenuButton menuButton = new MenuButton("Tipo",null,menuItemint,menuItemfloat,menuItemcadena,menuItemfecha_hora);
        menuButton.setLayoutX(130);
        menuButton.setLayoutY(245);



        // boton para mandar datos //


        Button boton_documento = new Button("Listo!");
        boton_documento.setLayoutX(250);
        boton_documento.setLayoutY(400);

        boton_documento.setOnAction(e -> {
            if (text_atributo_nombre.getText().equals("") || menu_botton_selected.equals("") || tipo_especial_atributo.getText().equals("")) {
                display();

            } else {
                if (nivel == 1) {
                    armarHijoArbol(padre_seleccionado, text_atributo_nombre.getText());

                    meter_en_documentos(padre_seleccionado, text_atributo_nombre.getText(), nivel, item_seleccionado.getValue(), menu_botton_selected, text_tipo_especial_atributo.getText());
                    menu_botton_selected = "";
                    ventana_documento.close();
                }
                if (nivel == 2) {
                    meter_en_documentos(padre_seleccionado, text_atributo_nombre.getText(), nivel, item_seleccionado.getValue(), menu_botton_selected, text_tipo_especial_atributo.getText());
                    menu_botton_selected = "";
                    ventana_documento.close();
                }


            }
        });

        // Terminado y metiendo todos los elementos dentro de la ventana //


        Pane canvas3 = new Pane();
        canvas3.getChildren().addAll(text_atributo_nombre, Nombre_Atributo, Tipo_del_atributo, tipo_especial_atributo, text_tipo_especial_atributo);
        canvas3.getChildren().addAll( imageView_documento, imageView_documento_palabra,menuButton);
        canvas3.getChildren().addAll(boton_documento);
        Scene scene2 = new Scene(canvas3, 600, 500);
        ventana_documento.setScene(scene2);
        ventana_documento.showAndWait();

        // Agarra los datos y crea el hijo //

    }
    public void meter_valores_en_observable_list(Nodo actual_1, ObservableList<Tabla_datos> data) {

        while (actual_1 != null) {

            data.add(new Tabla_datos(actual_1.getDato_JSON().get("Nombre: ").toString(), actual_1.getDato_JSON().get("Llave: ").toString(), actual_1.getDato_JSON().get("Tipo").toString()));
            actual_1 = actual_1.getSiguiente();
        }
    }

    public void Tabla(TreeItem<String> padre) {

        Objetos lista = listasStore.buscar_por_nombre(padre.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(padre.getValue()).getDato_Documento();
        listasStore.buscar_por_nombre(padre.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(padre.getValue()).getDato_Documento();

        Nodo actual = lista.dar_inicio();

        TableView<Tabla_datos> table = new TableView<Tabla_datos>();
        final ObservableList<Tabla_datos> data =
                FXCollections.observableArrayList(
                        new Tabla_datos("", "", "")

                );

        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Objetos en Memoria de " + padre.getValue());
        stage.setWidth(450);
        stage.setHeight(500);

        final Label label = new Label(padre.getValue());
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn NameCol = new TableColumn("Nombre");
        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<Tabla_datos, String>("Nombre"));

        TableColumn TipoCOL = new TableColumn("Tipo");
        TipoCOL.setMinWidth(100);
        TipoCOL.setCellValueFactory(
                new PropertyValueFactory<Tabla_datos, String>("Llave"));

        TableColumn LlaveCOL = new TableColumn("Llave");
        LlaveCOL.setMinWidth(200);
        LlaveCOL.setCellValueFactory(
                new PropertyValueFactory<Tabla_datos, String>("Tipo"));
        meter_valores_en_observable_list(actual,data);
        table.setItems(data);

        table.getColumns().addAll(NameCol, TipoCOL, LlaveCOL);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
    public  void deplejarVentanaNombreJSON() {


        Stage ventanita = new Stage();
        ventanita.initModality(Modality.APPLICATION_MODAL);
        ventanita.setTitle("Creando JSON store...");
        File file = new File("/Users/IsaacPorras/Downloads/Progra1/src/paquete1/img/user_image.png");
        String localUrl = file.toURI().toString();
        Image image = new Image(localUrl);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(200);
        imageView.setLayoutY(10);
        Label texto = new Label("Escriba el nombre del archivo:");
        texto.setLayoutX(10);
        texto.setLayoutY(100);


        TextField nombre = new TextField();
        nombre.setLayoutX(10);
        nombre.setLayoutY(120);
        nombre.minWidth(70);


        Button boton1 = new Button("Listo!");
        boton1.setLayoutX(200);
        boton1.setLayoutY(120);


        boton1.setOnAction(e -> {
            if (nombre.getText().equals("")) {
                return ;
            }
            else {
                crearElItem(nombre.getText());
                ventanita.close();
            }
        });


        canvas2 = new Pane();
        canvas2.getChildren().addAll(nombre,texto,imageView,boton1);


        Scene scene = new Scene(canvas2, 500,200);
        ventanita.setScene(scene);
        ventanita.showAndWait();

    }

    public void meter_en_documentos(TreeItem<String> padre, String nombre_doc , int nivel, String seleccionado,String tipo_del_atributo, String llave){



        if (nivel == 2){

            System.out.println("El padre de nivel 2 es :"+ padre.getParent().getValue());

            JSONObject nuevo_objeto = new JSONObject();

            nuevo_objeto.put("Nombre: ",nombre_doc);
            nuevo_objeto.put("Llave: ",llave);
            nuevo_objeto.put("Tipo",tipo_del_atributo);

            System.out.println("EL DATO DENTRO DE MI STORE ES : " + listasStore.buscar_por_nombre(padre.getParent().getValue()).getDato_Store());
            System.out.println(listasStore.buscar_por_nombre(padre.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(seleccionado).getDato_Documento());
            listasStore.buscar_por_nombre(padre.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(seleccionado).getDato_Documento().ingresarDato(nuevo_objeto);

            return ;

        }

        if ( nivel == 1) {

            System.out.println("El padre de nivel 1 es :" + padre.getValue());

            Objetos objetojson = new Objetos();


            JSONObject nuevo_objeto = new JSONObject();

            nuevo_objeto.put("Nombre: ",nombre_doc);
            nuevo_objeto.put("Llave: ",llave);
            nuevo_objeto.put("Tipo",tipo_del_atributo);

            objetojson.ingresarDato(nuevo_objeto);
            System.out.println("El dato de mi store este :"+listasStore.buscar_por_nombre(padre.getValue()).getDato_Store());


            if (listasStore.buscar_por_nombre(padre.getValue()).getDato_Store()!= null) {


                System.out.println("SE INSERTO POR SEGUNDA VEZ");
                listasStore.buscar_por_nombre(padre.getValue()).getDato_Store().ingresarDato(objetojson, nombre_doc);

                listasStore.buscar_por_nombre(padre.getValue()).getDato_Store().imprimir();

            }

            if (listasStore.buscar_por_nombre(padre.getValue()).getDato_Store()==null) {

                System.out.println("SE INSERTO POR PRIMERA VEZ");

                Documentos documentos1 = new Documentos();

                documentos1.ingresarDato(objetojson,nombre_doc);

                listasStore.buscar_por_nombre(padre.getValue()).setDato_Store(documentos1);

                listasStore.buscar_por_nombre(padre.getValue()).getDato_Store().imprimir();

            }

        }






    }

    public void eliminar_json_por_llave(){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Elimando Json...");
        window.setMinWidth(250);
        window.setMinHeight(50);

        Label label = new Label();
        label.setText("Digite la llave del objeto json: ");

        Button boton = new Button("OK");
        boton.setLayoutX(90);
        boton.setLayoutY(20);

        TextField llave = new TextField();
        llave.setLayoutX(10);
        llave.setLayoutY(120);
        llave.minWidth(70);

        boton.setOnAction(e-> {
            listasStore.buscar_por_nombre(arbol.getSelectionModel().selectedItemProperty().get().getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(arbol.getSelectionModel().selectedItemProperty().get().getValue()).getDato_Documento().eliminarObjeto(llave.getText());
            window.close();});

        Pane layout = new Pane();
        layout.getChildren().addAll(llave,label,boton);


        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
//    public void mostrar_objetos_en_memoria(TreeItem<String> padre, TreeItem<String> seleccionado){
//
//        System.out.println("-------------------------------");
//
//        System.out.println("LOS OBJETOS EN MEMORIA SON: ");
//        System.out.println("  ");
//
//        listasStore.buscar_por_nombre(padre.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(seleccionado.getValue()).getDato_Documento().imprimirObjectos();
//    }
    public void eliminar_objeto_JSON_sin_llave(){

    }



}