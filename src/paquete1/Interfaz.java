package paquete1;

import apple.laf.JRSUIUtils;
import com.sun.tools.classfile.Synthetic_attribute;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javax.print.DocFlavor;
import javax.swing.*;

public class Interfaz extends Application {
    RadioButton circulo_requerido;
    RadioButton circulo_no_requerido;
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

    public static void display() {

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
        deleteButton.setOnAction(e -> window.close());

        Pane layout = new Pane();
        layout.getChildren().addAll(label, deleteButton);


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
                            Ventana_crear_JSON_Object(arbol.getSelectionModel().selectedItemProperty().get());


                        }
                    }).build(),

                    MenuItemBuilder.create().text("Mostrar Objetos en Memoria").onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent arg0) {

//                            mostrar_objetos_en_memoria(arbol.getSelectionModel().selectedItemProperty().get(), arbol.getSelectionModel().selectedItemProperty().get());
                            Tabla(arbol.getSelectionModel().selectedItemProperty().get(),listasStore.buscar_por_nombre(arbol.getSelectionModel().selectedItemProperty().get().getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(arbol.getSelectionModel().selectedItemProperty().get().getValue()).getNombre(),listasStore.buscar_por_nombre(arbol.getSelectionModel().selectedItemProperty().get().getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(arbol.getSelectionModel().selectedItemProperty().get().getValue()).getLlave_primaria(), listasStore.buscar_por_nombre(arbol.getSelectionModel().selectedItemProperty().get().getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(arbol.getSelectionModel().selectedItemProperty().get().getValue()).getLlave_foranea());

                        }
                    }).build(),


                    MenuItemBuilder.create().text("Eliminar todos los Objeto JSON").onAction(new EventHandler<ActionEvent>() {
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
                    MenuItemBuilder.create().text("Buscar Objeto").onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent arg0) {
                            buscar_objeto();


                        }
                    }).build(),
                    MenuItemBuilder.create().text("Actualizar Objetos").onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent arg0) {
                            actualizar_objetos(listasStore.buscar_por_nombre(arbol.getSelectionModel().selectedItemProperty().get().getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(arbol.getSelectionModel().selectedItemProperty().get().getValue()).getDato_Documento(),"ATRIBUTO","CONDICION");
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

        // Tipo Especial : Primaria y foranea //

        //1.1.Primaria : Label

        Label tipo_especial_primaria = new Label("Llave Primaria :");
        tipo_especial_primaria.setLayoutX(20);
        tipo_especial_primaria.setLayoutY(300);
        //1.2.Primaria : TextField

        TextField text_tipo_especial_primaria= new TextField();
        text_tipo_especial_primaria.setLayoutX(130);
        text_tipo_especial_primaria.setLayoutY(295);
        text_tipo_especial_primaria.minWidth(60);

        //2.1.Foranea : Label

        Label tipo_especial_foranea = new Label("Llave Foranea :");
        tipo_especial_foranea.setLayoutX(20);
        tipo_especial_foranea.setLayoutY(330);

        //2.2.Foranea : Textfield

        TextField text_tipo_especial_foranea = new TextField();
        text_tipo_especial_foranea.setLayoutX(130);
        text_tipo_especial_foranea.setLayoutY(330);
        text_tipo_especial_foranea.minWidth(60);
        text_tipo_especial_foranea.setEditable(false);


        // BOTONES DE REQUERIDO O NO REQUERIDO //


        // 1. Requerido

        Label label_circulo_requerido = new Label("Requerido ");
        label_circulo_requerido.setLayoutX(10);
        label_circulo_requerido.setLayoutY(400);



        // 2. No requerido

        Label label_circulo_no_requerido = new Label("No Requerido ");
        label_circulo_no_requerido.setLayoutX(10);
        label_circulo_no_requerido.setLayoutY(430);



        circulo_no_requerido = new RadioButton();
        circulo_no_requerido.setLayoutX(100);
        circulo_no_requerido.setLayoutY(430);
        circulo_no_requerido.setOnAction(e->{
            circulo_requerido.setSelected(false);
            text_tipo_especial_foranea.setText(text_tipo_especial_primaria.getText());
            text_tipo_especial_foranea.setEditable(false);

        });
        circulo_requerido = new RadioButton();
        circulo_requerido.setLayoutX(100);
        circulo_requerido.setLayoutY(400);
        circulo_requerido.setOnAction(e->{
            circulo_no_requerido.setSelected(false);
            text_tipo_especial_foranea.setText("");
            text_tipo_especial_foranea.setEditable(true);

        });


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
            if (text_atributo_nombre.getText().equals("") || menu_botton_selected.equals("") || text_tipo_especial_primaria.getText().equals("") || text_tipo_especial_foranea.getText().equals("")) {
                display();

            } else {
                if (nivel == 1) {
                    armarHijoArbol(padre_seleccionado, text_atributo_nombre.getText());

                    meter_en_documentos(padre_seleccionado, text_atributo_nombre.getText(), nivel, item_seleccionado.getValue(), menu_botton_selected, text_tipo_especial_primaria.getText(),text_tipo_especial_foranea.getText());
                    menu_botton_selected = "";
                    ventana_documento.close();
                }
                if (nivel == 2) {
                    meter_en_documentos(padre_seleccionado, text_atributo_nombre.getText(), nivel, item_seleccionado.getValue(), menu_botton_selected, text_tipo_especial_primaria.getText(), text_tipo_especial_foranea.getText());
                    menu_botton_selected = "";
                    ventana_documento.close();
                }


            }
        });

        // Terminado y metiendo todos los elementos dentro de la ventana //


        Pane canvas3 = new Pane();
        canvas3.getChildren().addAll(text_atributo_nombre, Nombre_Atributo, Tipo_del_atributo, tipo_especial_primaria, text_tipo_especial_primaria);
        canvas3.getChildren().addAll( imageView_documento, imageView_documento_palabra,menuButton, tipo_especial_foranea, text_tipo_especial_foranea);
        canvas3.getChildren().addAll(boton_documento, circulo_requerido, circulo_no_requerido, label_circulo_requerido, label_circulo_no_requerido);
        Scene scene2 = new Scene(canvas3, 600, 500);
        ventana_documento.setScene(scene2);
        ventana_documento.showAndWait();

        // Agarra los datos y crea el hijo //

    }


    public void meter_valores_en_observable_list(Nodo actual_1, ObservableList<Tabla_datos> data , Documentos lista) {

        while (actual_1 != null) {

            data.add(new Tabla_datos(actual_1.getDato_JSON().get("Nombre: ").toString(), actual_1.getDato_JSON().get("Llave: ").toString(), actual_1.getDato_JSON().get("Tipo").toString()));
            actual_1 = actual_1.getSiguiente();

        }
    }

    public void Tabla(TreeItem<String> padre, String nombre_tabla, String llave1, String llave2) {

        System.out.println("TABLA :");

        Objetos lista = listasStore.buscar_por_nombre(padre.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(padre.getValue()).getDato_Documento();

        Nodo actual = lista.dar_inicio();

        TableView<Tabla_datos> table = new TableView<Tabla_datos>();
        final ObservableList<Tabla_datos> data =
                FXCollections.observableArrayList(
                        new Tabla_datos("", "", "")

                );

        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Objetos en Memoria de " + padre.getValue());
        stage.setWidth(620);
        stage.setHeight(470);

        final Label label = new Label(padre.getValue());
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn NameCol = new TableColumn(nombre_tabla);
        NameCol.setMinWidth(200);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<Tabla_datos, String>("Nombre"));

        TableColumn TipoCOL = new TableColumn(llave2);
        TipoCOL.setMinWidth(200);
        TipoCOL.setCellValueFactory(
                new PropertyValueFactory<Tabla_datos, String>("Llave"));

        TableColumn LlaveCOL = new TableColumn(llave1);
        LlaveCOL.setMinWidth(200);
        LlaveCOL.setCellValueFactory(
                new PropertyValueFactory<Tabla_datos, String>("Tipo"));
        System.out.println(actual);

        meter_valores_en_observable_list(actual, data, listasStore.buscar_por_nombre(padre.getParent().getValue()).getDato_Store());
        table.setItems(data);


        table.getColumns().addAll(NameCol, LlaveCOL, TipoCOL);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public void deplejarVentanaNombreJSON() {


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
                return;
            } else {
                crearElItem(nombre.getText());
                ventanita.close();
            }
        });


        canvas2 = new Pane();
        canvas2.getChildren().addAll(nombre, texto, imageView, boton1);


        Scene scene = new Scene(canvas2, 600, 200);
        ventanita.setScene(scene);
        ventanita.showAndWait();

    }

    public void meter_en_documentos(TreeItem<String> padre, String nombre_doc, int nivel, String seleccionado, String tipo_del_atributo, String llave_primaria, String llave_foranea) {


        if (nivel == 2) {

            System.out.println("El padre de nivel 2 es :" + padre.getParent().getValue());

            JSONObject nuevo_objeto = new JSONObject();

            nuevo_objeto.put("Nombre: ", nombre_doc);
            nuevo_objeto.put("Llave: ", llave_primaria);
            nuevo_objeto.put("Tipo", tipo_del_atributo);

            System.out.println("EL DATO DENTRO DE MI STORE ES : " + listasStore.buscar_por_nombre(padre.getParent().getValue()).getDato_Store());
            System.out.println(listasStore.buscar_por_nombre(padre.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(seleccionado).getDato_Documento());
            listasStore.buscar_por_nombre(padre.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(seleccionado).getDato_Documento().ingresarDato(nuevo_objeto);

            return;

        }

        if (nivel == 1) {



            System.out.println("El padre de nivel 1 es :" + padre.getValue());

            Objetos objetojson = new Objetos();


            JSONObject nuevo_objeto = new JSONObject();

            nuevo_objeto.put("Nombre: ", nombre_doc);
            nuevo_objeto.put("Llave: ", llave_primaria);
            nuevo_objeto.put("Tipo", tipo_del_atributo);

            System.out.println("El dato de mi store este :" + listasStore.buscar_por_nombre(padre.getValue()).getDato_Store());


            if (listasStore.buscar_por_nombre(padre.getValue()).getDato_Store() != null) {


                System.out.println("SE INSERTO POR SEGUNDA VEZ");

                listasStore.buscar_por_nombre(padre.getValue()).getDato_Store().ingresarDato(objetojson, nombre_doc,nombre_doc,tipo_del_atributo,llave_primaria,llave_foranea);

                listasStore.buscar_por_nombre(padre.getValue()).getDato_Store().imprimir();

            }

            if (listasStore.buscar_por_nombre(padre.getValue()).getDato_Store() == null) {

                System.out.println("SE INSERTO POR PRIMERA VEZ");

                Documentos documentos1 = new Documentos();



                listasStore.buscar_por_nombre(padre.getValue()).setDato_Store(documentos1);



                listasStore.buscar_por_nombre(padre.getValue()).getDato_Store().ingresarDato(objetojson, nombre_doc, nombre_doc,tipo_del_atributo,llave_primaria,llave_foranea);
                listasStore.buscar_por_nombre(padre.getValue()).getDato_Store().imprimir();
            }

        }


    }

    public void eliminar_json_por_llave() {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Elimando Json...");
        window.setMinWidth(250);
        window.setMinHeight(60);

        Label label = new Label();
        label.setText("Digite la llave del objeto json: ");

        Button boton = new Button("OK");
        boton.setLayoutX(190);
        boton.setLayoutY(20);

        TextField llave = new TextField();
        llave.setLayoutX(10);
        llave.setLayoutY(20);
        llave.minWidth(70);

        boton.setOnAction(e -> {
            listasStore.buscar_por_nombre(arbol.getSelectionModel().selectedItemProperty().get().getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(arbol.getSelectionModel().selectedItemProperty().get().getValue()).getDato_Documento().eliminarObjeto(llave.getText());
            window.close();
        });

        Pane layout = new Pane();
        layout.getChildren().addAll(llave, label, boton);


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

    public void display_no_es_tipo() {


        Stage window_no_es_tipo = new Stage();
        window_no_es_tipo.initModality(Modality.APPLICATION_MODAL);
        window_no_es_tipo.setTitle("Error!");
        window_no_es_tipo.setMinWidth(250);
        window_no_es_tipo.setMinHeight(50);

        Label label_no_es_tipo = new Label();
        label_no_es_tipo.setText("El tipo ingresado no concuerda con el establecido");
        Button deleteButton_no_es_tipo = new Button("OK");
        deleteButton_no_es_tipo.setLayoutX(90);
        deleteButton_no_es_tipo.setLayoutY(20);

        Pane layout_no_es_tipo= new Pane();
        layout_no_es_tipo.getChildren().addAll(label_no_es_tipo, deleteButton_no_es_tipo);


        Scene scene_no_es_tipo = new Scene(layout_no_es_tipo);
        deleteButton_no_es_tipo.setOnAction(e->
                window_no_es_tipo.close());

        window_no_es_tipo.setScene(scene_no_es_tipo);

        window_no_es_tipo.showAndWait();

    }
    public void Ventana_crear_JSON_Object(TreeItem<String> seleccionado){


        String seleccionado2 = seleccionado.getValue();
        String nombre_atributo = listasStore.buscar_por_nombre(seleccionado.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(seleccionado2).getNombre_atributo();
        String tipo = listasStore.buscar_por_nombre(seleccionado.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(seleccionado2).getTipo_atributo();
        String llave_primaria = listasStore.buscar_por_nombre(seleccionado.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(seleccionado2).getLlave_primaria();
        String llave_foranea = listasStore.buscar_por_nombre(seleccionado.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(seleccionado2).getLlave_foranea();
        Stage ventana_json_object = new Stage();

        System.out.println("******** EL TIPO ES :"+ tipo);

        ventana_json_object.initModality(Modality.APPLICATION_MODAL);
        ventana_json_object.setTitle("Creando JSON object...");


        // Nombre del Documento  //

        Text Nombre_Atributo_JSON = new Text(nombre_atributo);
        Nombre_Atributo_JSON.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20) );
        Nombre_Atributo_JSON.setLayoutX(20);
        Nombre_Atributo_JSON.setLayoutY(20);



        //Tipo de atributo //


        Label tipo_especial_primaria_JSON = new Label(llave_primaria + " : ");
        tipo_especial_primaria_JSON.setLayoutX(20);
        tipo_especial_primaria_JSON.setLayoutY(40);
        //1.2.Primaria : TextField

        TextField text_tipo_especial_primaria_JSON= new TextField();
        text_tipo_especial_primaria_JSON.setLayoutX(130);
        text_tipo_especial_primaria_JSON.setLayoutY(40);
        text_tipo_especial_primaria_JSON.minWidth(60);

        //2.1.Foranea : Label



        Label tipo_especial_foranea_JSON = new Label(llave_foranea + " : ");
        tipo_especial_foranea_JSON.setLayoutX(20);
        tipo_especial_foranea_JSON.setLayoutY(70);

        //2.2.Foranea : Textfield

        TextField text_tipo_especial_foranea_JSON = new TextField();
        text_tipo_especial_foranea_JSON.setLayoutX(130);
        text_tipo_especial_foranea_JSON.setLayoutY(70);
        text_tipo_especial_foranea_JSON.minWidth(60);


        if (llave_foranea.equals(llave_primaria)){

            text_tipo_especial_foranea_JSON.setEditable(false);
            text_tipo_especial_foranea_JSON.setVisible(false);
            tipo_especial_foranea_JSON.setVisible(false);

        }


        Button boton_json_object = new Button("Listo!");
        boton_json_object.setLayoutX(240);
        boton_json_object.setLayoutY(110);
        boton_json_object.setOnAction(e->{

            if (llave_foranea.equals(llave_primaria)){
                text_tipo_especial_foranea_JSON.setText(text_tipo_especial_primaria_JSON.getText());
            }
            System.out.println("el tipo es :" + tipo);

            if (!text_tipo_especial_foranea_JSON.getText().equals("") && !text_tipo_especial_primaria_JSON.getText().equals("")){
                if (tipo.equals("int")){
                    if (!verificar_que_tipo(text_tipo_especial_primaria_JSON.getText()).equals("int") ){
                        System.out.println("no es entero");
                        display_no_es_tipo();
                        return;
                    }

                }
                if(tipo.equals("float")){
                    if (!verificar_que_tipo(text_tipo_especial_primaria_JSON.getText()).equals("float")){
                        System.out.println("no es Float");
                        display_no_es_tipo();
                        return;
                    }

                }
                if(tipo.equals("cadena")){
                    if (!verificar_que_tipo(text_tipo_especial_primaria_JSON.getText()).equals("cadena")){
                        System.out.println("no es Cadena");
                        display_no_es_tipo();
                        return;

                    }

                }
                if (tipo.equals("fecha-hora")){
                    if (!verificar_que_tipo(text_tipo_especial_primaria_JSON.getText()).equals("fecha-hora")){
                        System.out.println("no es Fecha - Hora");
                        display_no_es_tipo();
                        return;
                    }

                }

            }


            if (text_tipo_especial_primaria_JSON.getText().equals("")  || text_tipo_especial_foranea_JSON.getText().equals("")){
                System.out.println("NO SE ESCRIBIO NADA");
                display();
            }
            if(!text_tipo_especial_primaria_JSON.getText().equals("")  && !text_tipo_especial_foranea_JSON.getText().equals("")){
                System.out.println("SI SE ESCRIBIO ALGO");
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("Nombre: ","");
                jsonObject.put("Llave: ", text_tipo_especial_primaria_JSON.getText());
                jsonObject.put("Tipo",text_tipo_especial_foranea_JSON.getText());

                listasStore.buscar_por_nombre(seleccionado.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(seleccionado2).getDato_Documento().ingresarDato(jsonObject);
                listasStore.buscar_por_nombre(seleccionado.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(seleccionado2).getDato_Documento().imprimirObjectos();
                ventana_json_object.close();
            }
        });

        Pane canvas_json = new Pane();
        canvas_json.getChildren().addAll(Nombre_Atributo_JSON, text_tipo_especial_primaria_JSON, text_tipo_especial_foranea_JSON, boton_json_object,tipo_especial_foranea_JSON, tipo_especial_primaria_JSON);
        Scene scene2 = new Scene(canvas_json, 320, 150);
        ventana_json_object.setScene(scene2);
        ventana_json_object.showAndWait();

    }
    public String verificar_que_tipo(String dato){
        if (numerico(dato).equals("int")){
            return "int";
        }
        if (numerico(dato).equals("float")){
            return "float";
        }
        if (fecha_hora(dato)){
            return "fecha-hora";
        }
        if(numerico(dato).equals("NO NUMERICO")){
            return "cadena";
        }
        return "NINGUNO";
    }

    public String numerico(String numero){
        if(numero.contains(".")) {

            System.out.println("EL NUMERO QUITANDOLE EL PUNTO ES :"+numero.replace(".", "2"));
            try {
                Integer.parseInt(numero.replace(".", "2"));
                return "float";

            }
            catch (NumberFormatException nsd){
                return "NO NUMERICO";
            }
        }
        try{

            Integer.parseInt(numero);
            if (Integer.parseInt(numero) % 1 == 0){
                return "int";
            }
        }
        catch (NumberFormatException nfe) {
            return "NO NUMERICO";
        }
        return "NINGUNO ALV";
    }
    public boolean fecha_hora(String fecha){
        if(fecha.contains("/")|| (fecha.contains(":")&& fecha.length()== 5)){
            return true;
        }
        else{
            return false;
        }

    }
    public void meter_valores_en_lista_buscar(Nodo actual_1, ObservableList<Tabla_datos> data , Documentos lista, String atributo_buscado, String seleccionado) {

        while (actual_1 != null) {
            if (atributo_buscado.equals(actual_1.getDato_JSON().get("Nombre: ").toString()) ||  atributo_buscado.equals(actual_1.getDato_JSON().get("Llave: ").toString())    ||   atributo_buscado.equals(actual_1.getDato_JSON().get("Tipo").toString())){
                data.add(new Tabla_datos(actual_1.getDato_JSON().get("Nombre: ").toString(), actual_1.getDato_JSON().get("Llave: ").toString(), actual_1.getDato_JSON().get("Tipo").toString()));
                actual_1 = actual_1.getSiguiente();
            }
            else{
                actual_1 = actual_1.getSiguiente();
            }



        }
    }

    public void Tabla_buscar(TreeItem<String> padre, String nombre_tabla, String llave1, String llave2, String atributo_buscado) {

        System.out.println("TABLA :");

        Objetos lista = listasStore.buscar_por_nombre(padre.getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(padre.getValue()).getDato_Documento();

        Nodo actual = lista.dar_inicio();

        TableView<Tabla_datos> table = new TableView<Tabla_datos>();
        final ObservableList<Tabla_datos> data =
                FXCollections.observableArrayList(
                        new Tabla_datos("", "", "")

                );

        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Objetos Buscados");
        stage.setWidth(620);
        stage.setHeight(470);

        final Label label = new Label("Objetos encontrados:");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn NameCol = new TableColumn("Tipo");
        NameCol.setMinWidth(200);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<Tabla_datos, String>("Nombre"));

        TableColumn TipoCOL = new TableColumn("Llave Foranea");
        TipoCOL.setMinWidth(200);
        TipoCOL.setCellValueFactory(
                new PropertyValueFactory<Tabla_datos, String>("Llave"));

        TableColumn LlaveCOL = new TableColumn("Llave Primaria");
        LlaveCOL.setMinWidth(200);
        LlaveCOL.setCellValueFactory(
                new PropertyValueFactory<Tabla_datos, String>("Tipo"));
        System.out.println(actual);

        meter_valores_en_lista_buscar(actual, data, listasStore.buscar_por_nombre(padre.getParent().getValue()).getDato_Store(),atributo_buscado,padre.getValue());

        table.setItems(data);


        table.getColumns().addAll(NameCol, LlaveCOL, TipoCOL);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
    public void buscar_objeto() {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Buscar");
        window.setMinWidth(250);
        window.setMinHeight(60);

        Label label = new Label();
        label.setText("Digite el atributo a buscar ");

        Button boton = new Button("OK");
        boton.setLayoutX(190);
        boton.setLayoutY(20);

        TextField llave = new TextField();
        llave.setLayoutX(10);
        llave.setLayoutY(20);
        llave.minWidth(70);

        boton.setOnAction(e -> {
            Tabla_buscar(arbol.getSelectionModel().selectedItemProperty().get(),listasStore.buscar_por_nombre(arbol.getSelectionModel().selectedItemProperty().get().getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(arbol.getSelectionModel().selectedItemProperty().get().getValue()).getNombre(),listasStore.buscar_por_nombre(arbol.getSelectionModel().selectedItemProperty().get().getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(arbol.getSelectionModel().selectedItemProperty().get().getValue()).getLlave_primaria(), listasStore.buscar_por_nombre(arbol.getSelectionModel().selectedItemProperty().get().getParent().getValue()).getDato_Store().buscar_por_nombre_Documentos(arbol.getSelectionModel().selectedItemProperty().get().getValue()).getLlave_foranea(),llave.getText());
            window.close();
        });

        Pane layout = new Pane();
        layout.getChildren().addAll(llave, label, boton);


        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public void actualizar_objetos(Objetos lista , String atributo_a_actualizar, String condicion){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Actualizar");
        window.setMinWidth(800);
        window.setMinHeight(150);



        Label label_nuevo_atributo = new Label();
        label_nuevo_atributo.setText("Digite el nuevo atributo: ");
        label_nuevo_atributo.setLayoutY(20);
        label_nuevo_atributo.setLayoutX(20);

        Label label_condicion = new Label();
        label_condicion.setText("Digite la condición de busqueda:");
        label_condicion.setLayoutY(60);
        label_condicion.setLayoutX(20);

        Button boton = new Button("OK");
        boton.setLayoutX(450);
        boton.setLayoutY(80);


        TextField text_condicion = new TextField();
        text_condicion.setLayoutX(250);
        text_condicion.setLayoutY(60);
        text_condicion.minWidth(70);

        TextField text_nuevo_atributo = new TextField();
        text_nuevo_atributo.setLayoutX(250);
        text_nuevo_atributo.setLayoutY(20);
        text_nuevo_atributo.minWidth(70);

        boton.setOnAction(e -> {
            Nodo actual = lista.dar_inicio();
            while (actual!= null){
                if (actual.getDato_JSON().get("Tipo").equals(text_condicion.getText())){
                    actual.getDato_JSON().replace("Llave: ", text_nuevo_atributo.getText());
                    actual = actual.getSiguiente();
                }
                else{
                    actual = actual.getSiguiente();
                }
            }
            actual = lista.dar_inicio();
            while (actual!= null){
                if (actual.getDato_JSON().get("Llave: ").equals(text_condicion.getText())){
                    actual.getDato_JSON().replace("Tipo", text_nuevo_atributo.getText());
                    actual = actual.getSiguiente();
                }
                else{
                    actual = actual.getSiguiente();
                }
            }

            window.close();
        });

        Pane layout = new Pane();
        layout.getChildren().addAll(text_condicion, label_condicion, boton, text_nuevo_atributo, label_nuevo_atributo);


        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }







}