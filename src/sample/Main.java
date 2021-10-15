package sample;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import static javafx.scene.text.Font.font;

import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javax.swing.JOptionPane;
import java.awt.font.ImageGraphicAttribute;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TableView;

public class Main extends Application {
    Image image = new Image("file:///project image\\kxUyuPUh.jpg");
    Image image1 = new Image("file:///project image\\icons8-user-male-90.png");
    Image bakeGround2=new Image("file:///project image\\page2.jpg");
    Image userPhoto = new Image("file:///project image\\icons8-male-user-48.png");
    Image insertT = new Image("file:///project image\\icons8-insert-table-96.png");
    Image deleteT = new Image("file:///project image\\icons8-delete-table-96.png");
    Image updateT = new Image("file:///project image\\icons8-update-96.png");
    Image viewT = new Image("file:///project image\\icons8-view-96.png");
    Image backB =  new Image("file:///project image\\icons8-back-48.png");

    private final TableView <Schedule> table = new TableView<>();
    private final ObservableList<Schedule> dataList =
            FXCollections.observableArrayList();
//(new Schedule("4233","OOP","Mo-Tu_Th")
    TextField field;
    PasswordField field1;
    @Override
    public void start(Stage primaryStage) throws Exception, SQLException, ClassNotFoundException {
        //DATABSE
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String dbURL2 = "jdbc:oracle:thin:@localhost:1521/XE";
        String username = "ameedtamimi";
        String password = "2323";
        Connection con = DriverManager.getConnection(dbURL2, username, password);
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        /////////////////////////////////////////////
        //Sign Page
        Pane box = new Pane();
        VBox vBox= new VBox(10);
        Font font = Font.font("Segoe UI Black",50);

        //
        Label label = new Label("Sign In");
        Label label1 = new Label("User Name:");
         field = new TextField();

        Label label2 = new Label("Password:");
         field1 = new PasswordField();
        Button buttonSign = new Button("Sign In");//Sign button
        field.setPrefSize(135,30);
        field1.setPrefSize(135,30);
        buttonSign.setPrefSize(100,40);
        //VBOX
        vBox.getChildren().addAll(label1,field,label2,field1);

        vBox.setTranslateX(150);
        vBox.setTranslateY(350);

        label.setTranslateX(120);
        label.setTranslateY(100);

        buttonSign.setTranslateY(500);
        buttonSign.setTranslateX(165);
        label.setFont(font);
       //System.out.println(Font.getFamilies());

        ImageView imageView = new ImageView(image);
        ImageView imageView1 = new ImageView(image1);

        imageView1.setTranslateX(157);
        imageView1.setTranslateY(250);
        imageView.setFitHeight(650);
        imageView.setFitWidth(400);
        //PANE BOX
        box.getChildren().addAll(imageView,label,imageView1,vBox,buttonSign);
        Scene scene =new Scene(box,400,650);
        scene.getStylesheets().add("stylesheet.css");
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();

        //End sign page
        buttonSign.setOnAction(event -> {

           try {
               ResultSet query = stmt.executeQuery("select * from users");
               while (query.next()) {
                   if (field.getText().equals(query.getString("USERNAME")) && field1.getText().equals(query.getString(2))) {
                       //Main Page
                       Font font2 = Font.font("Muna",FontWeight.BLACK ,20);
                       Font font3 = Font.font("Segoe UI Black",40);
                       Font font4 = Font.font("Muna",FontWeight.BLACK ,16);
                       Font font5 = Font.font("Muna",FontWeight.BLACK ,13);
                       Pane box1 = new Pane();
                       ImageView viewGround2 = new ImageView(bakeGround2);
                       ImageView viewUser = new ImageView(userPhoto);
                       ImageView viewInsert = new ImageView(insertT);
                       ImageView viewDelete = new ImageView(deleteT);
                       ImageView viewUpdate = new ImageView(updateT);
                       ImageView viewTable = new ImageView(viewT);

                       Label labelName = new Label("Hello " + field.getText());

                       labelName.setFont(font2);

                       viewUser.setTranslateX(0);
                       viewUser.setTranslateY(0);

                       viewInsert.setTranslateX(40);
                       viewInsert.setTranslateY(100);

                       viewDelete.setTranslateX(270);
                       viewDelete.setTranslateY(100);

                       viewUpdate.setTranslateX(40);
                       viewUpdate.setTranslateY(350);

                       viewTable.setTranslateX(270);
                       viewTable.setTranslateY(350);

                       labelName.setTranslateX(50);
                       labelName.setTranslateY(10);

                       box1.getChildren().addAll(viewGround2, viewUser, labelName,viewInsert,
                               viewDelete,viewUpdate,viewTable);

                       Scene scene1 = new Scene(box1, 400, 650);
                       Stage stage1 = new Stage();

                       stage1.setTitle("Page2");
                       stage1.setScene(scene1);
                       stage1.show();
                       primaryStage.close();
                       viewInsert.setOnMouseClicked(eventInsert ->{
                           //Insert Page
                             Pane sPag = new Pane();
                             VBox boxForFill = new VBox(20);
                           ImageView viewPageInsert  = new ImageView(bakeGround2);
                           ImageView backb1 = new ImageView(backB);
                           Button buttonT = new Button("test");

                           viewPageInsert.setFitWidth(400);
                           viewPageInsert.setFitHeight(650);

                           Label numberOfSubject = new Label("Id of subject");
                           TextField fieldOfSubject = new TextField();
                           Label nameOfSubject = new Label("Name of subject");
                           TextField fieldOfName = new TextField();
                           Label numberOfClass = new Label("Number of class");
                           TextField fieldOfClass = new TextField();
                           Label days = new Label("Days");
                           TextField fieldOfDays = new TextField();
                           Label nameOfTeacher = new Label("Name of teacher");
                           TextField fieldOfTeacher = new TextField();
                           Label labelOfHead = new Label("Insert Page");

                           numberOfSubject.setFont(font2);
                           nameOfSubject.setFont(font2);
                           numberOfClass.setFont(font2);
                           days.setFont(font2);
                           nameOfTeacher.setFont(font2);

                           labelOfHead.setFont(font3);
                           Button buttonInsert = new Button("Insert");
                           Button buttonClose = new Button("close");

                           buttonInsert.setFont(font2);

                            boxForFill.setTranslateX(140);
                            boxForFill.setTranslateY(100);
                            labelOfHead.setTranslateX(105);
                            labelOfHead.setTranslateY(40);
                            buttonInsert.setTranslateY(580);
                            buttonInsert.setTranslateX(170);

                           boxForFill.getChildren().addAll(numberOfSubject,fieldOfSubject,nameOfSubject,fieldOfName,
                                   numberOfClass,fieldOfClass,days,fieldOfDays,nameOfTeacher,fieldOfTeacher);

                           sPag.getChildren().addAll(viewPageInsert,boxForFill,labelOfHead,buttonInsert,backb1);
                           Scene scene2 = new Scene(sPag,400,650);
                           Stage stage2 = new Stage();

                           stage2.setTitle("Insert Page");
                           stage2.setScene(scene2);
                           stage2.show();
                           stage1.close();
                           //insertPage
                           buttonInsert.setOnAction(insert ->{
                               String NUMBER_OF_SUBJECT = fieldOfSubject.getText()+"."+field.getText();
                               String NAME_OF_SUBJECT = fieldOfName.getText();
                               String CLASS_NUMBER = fieldOfClass.getText();
                               String DAYS = fieldOfDays.getText();
                               String NAME_OF_TEACHER = fieldOfTeacher.getText();
                               String userName = field.getText();
                               try {
                                   PreparedStatement query2 = con.prepareStatement("INSERT INTO SCHEDULE VALUES(?,?,?,?,?,?)");
                                   query2.setString(1,NUMBER_OF_SUBJECT);
                                   query2.setString(2,NAME_OF_SUBJECT);
                                   query2.setString(3,CLASS_NUMBER);
                                   query2.setString(4,DAYS);
                                   query2.setString(5,NAME_OF_TEACHER);
                                   query2.setString(6,userName);
                                   int cunt =query2.executeUpdate();
                                   if(cunt==1){
                                       JOptionPane.showMessageDialog(null,"Insert completed!");
                                   }

                               }
                               catch (SQLException throwables) {
                                  JOptionPane.showMessageDialog(null,"Wrong Please Fill the data!");
                               }

                           });//insertButton
                            backb1.setOnMouseClicked(close ->{
                                stage2.close();
                                stage1.show();
                            } );//closeButtonInsertPage


                       } );//////////endInsertPage
                       viewDelete.setOnMouseClicked(deletePage ->{
                           Pane holder = new Pane();
                            ImageView viewD = new ImageView(bakeGround2);
                            ImageView back2 = new ImageView(backB);
                            Label labelD = new Label("Delete Subject");
                            Label labelE = new Label("Enter the Sub Id");
                            TextField fieldD =new TextField();
                            Button buttonDelete = new Button("Delete Sub!");
                            Button buttonBake = new Button("Back");
                            labelD.setFont(font3);
                            labelE.setFont(font2);
                            buttonDelete.setFont(font2);


                            labelD.setTranslateX(50);
                            labelD.setTranslateY(15);

                            labelE.setTranslateX(125);
                            labelE.setTranslateY(105);

                            fieldD.setTranslateX(125);
                            fieldD.setTranslateY(150);

                            buttonDelete.setTranslateX(135);
                            buttonDelete.setTranslateY(200);

                            fieldD.setPrefSize(150,30);

                          holder.getChildren().addAll(viewD,labelD,labelE,fieldD,buttonDelete,back2);

                           Scene sceneDelete = new Scene(holder,400,250);
                           Stage stageDelete = new Stage();
                           stageDelete.setTitle("Delete Page");
                           stageDelete.setScene(sceneDelete);
                           stageDelete.show();
                           stage1.close();
                           back2.setOnMouseClicked(back ->{
                               stageDelete.close();
                               stage1.show();
                           });
                           buttonDelete.setOnAction(delete ->{
                               String idSub = fieldD.getText() + "." + field.getText();
                               try {
                                   PreparedStatement query3 =con.prepareStatement("delete from SCHEDULE where NUMBER_OF_SUBJECT=?");
                                   query3.setString(1,idSub);
                                   int countD =query3.executeUpdate();
                                   if(countD==1){
                                       JOptionPane.showMessageDialog(null,"Deleted!");
                                   }
                                   else{
                                       JOptionPane.showMessageDialog(null,"Is deleted");
                                   }
                               } catch (SQLException throwables) {
                                   JOptionPane.showMessageDialog(null,"Please fill the field");
                               }
                           } );

                       } );//endDelete

                       viewTable.setOnMouseClicked(viewData ->{
                           String subN = field.getText();

                           Pane holderData = new Pane();

                           ImageView data = new ImageView(bakeGround2);
                           ImageView back3 = new ImageView(backB);
                           Label houerOfSub;
                            table.setTranslateY(50);
                             table.setPrefSize(400,300);
                                Integer counter = 0;
                           try {
                               PreparedStatement query4 = con.prepareStatement("select substr(NUMBER_OF_SUBJECT,1,instr(NUMBER_OF_SUBJECT,'.')),NAME_OF_SUBJECT,DAYS from SCHEDULE where USERNAME = ?");
                               query4.setString(1,subN);
                               ResultSet rs1 = query4.executeQuery();
                                 while (rs1.next()) {
                                 Schedule col1 = new Schedule(rs1.getString(1),rs1.getString(2),rs1.getString(3));
                                   dataList.add(col1);
                                   if(rs1.getString(2).toString().contains("Lab")) {
                                        counter++;
                                   }
                                   else{
                                       counter+=3;
                                     }

                                 }

                           }
                           catch (SQLException throwables) {
                               throwables.printStackTrace();
                           }
                           houerOfSub = new Label("Total registered hours: "+counter.toString()+" credit hours");
                            houerOfSub.setFont(font4);
                           houerOfSub.setTranslateY(350);

                           table.setEditable(true);
                           TableColumn firstNameCol = new TableColumn("Subject Id");
                           firstNameCol.setMinWidth(100);
                           firstNameCol.setCellValueFactory(new PropertyValueFactory<String , String>("subId"));

                           TableColumn midCol = new TableColumn("Subject name");
                           midCol.setMinWidth(200);
                           midCol.setCellValueFactory(new PropertyValueFactory<String, String>("nameOfSub"));



                           TableColumn lastNameCol = new TableColumn("Days");
                           lastNameCol.setMinWidth(100);
                           lastNameCol.setCellValueFactory(new PropertyValueFactory<Schedule , String>("Days"));

                           table.setItems(dataList);
                           table.getColumns().addAll(firstNameCol,midCol,lastNameCol);

                           holderData.getChildren().addAll(data,table,back3,houerOfSub);

                           Scene sceneViwData = new Scene(holderData,400,650);
                           Stage stageData = new Stage();
                           stageData.setTitle("View Page");
                           stageData.setScene(sceneViwData);
                           stageData.show();
                          stage1.close();
                           back3.setOnMouseClicked(back ->{
                               stageData.close();
                               stage1.show();
                               dataList.clear();
                           });


                       } ); ///end of tableView

                       //startOfUpdate
                       viewUpdate.setOnMouseClicked(updatePage ->{
                           Pane paneUp= new Pane();
                           VBox boxUpdate = new VBox(20);
                           ImageView viewUp = new ImageView(bakeGround2);
                           ImageView back4 = new ImageView(backB);
                           boxUpdate.setTranslateY(50);


                            Label fill = new Label("class:");
                            fill.setFont(font4);
                            Label Id = new Label("Sub Id:");
                            Id.setFont(font4);
                            fill.setVisible(false);
                            Id.setVisible(false);
                           Button backUp = new Button("reset");
                           backUp.setFont(font5);
                           backUp.setVisible(false);
                           backUp.setTranslateY(240);
                           backUp.setTranslateX(170);

                           HBox b  = new HBox(10);
                           TextField f1 = new TextField();
                           TextField f2 = new TextField();

                           f1.setVisible(false);
                           f2.setVisible(false);
                           f1.setPrefSize(100,30);
                           f2.setPrefSize(100,30);

                           Button b2 = new Button("Update");
                           b2.setFont(font5);
                           b2.setVisible(false);
                           b.getChildren().addAll(fill,f1,Id,f2,b2);

                           Button buttonCilkHere = new Button("Click Here!");
                           buttonCilkHere.setTranslateY(190);
                           buttonCilkHere.setTranslateX(170);
                           buttonCilkHere.setPrefSize(100,30);

                           RadioButton radioButtonClass = new RadioButton("Update Class Number");
                           RadioButton radioButtonDays = new RadioButton("UpDate Day");
                           RadioButton radioButtonTeacher = new RadioButton("Update Teacher");

                           ToggleGroup groupUp  = new ToggleGroup();
                           radioButtonClass.setToggleGroup(groupUp);
                           radioButtonDays.setToggleGroup(groupUp);
                           radioButtonTeacher.setToggleGroup(groupUp);

                           radioButtonClass.setFont(font2);
                           radioButtonDays.setFont(font2);
                           radioButtonTeacher.setFont(font2);

                           buttonCilkHere.setOnAction(actonProcess ->{
                               if(radioButtonDays.isSelected()){
                                   f1.setVisible(true);
                                   f2.setVisible(true);
                                   b2.setVisible(true);
                                   fill.setVisible(true);
                                   Id.setVisible(true);
                                   backUp.setVisible(true);
                                   fill.setText("Days:");
                                   buttonCilkHere.setVisible(false);

                                   b2.setOnAction(event1 -> {
                                       try {
                                           String  q1 = f1.getText();   //fieldD.getText() + "." + field.getText();
                                           String q2 = f2.getText()+"."+field.getText();
                                           PreparedStatement query5 = con.prepareStatement("UPDATE SCHEDULE SET DAYS = ? WHERE NUMBER_OF_SUBJECT= ? ");
                                           query5.setString(1,q1);
                                           query5.setString(2,q2);
                                           int count = query5.executeUpdate();
                                           if(count==1){
                                               JOptionPane.showMessageDialog(null,"done");
                                           }
                                       } catch (SQLException throwables) {
                                           throwables.printStackTrace();
                                       }
                                   });
                                   backUp.setOnAction(reset -> {
                                       f1.setVisible(false);
                                       f2.setVisible(false);
                                       b2.setVisible(false);
                                       fill.setVisible(false);
                                       Id.setVisible(false);
                                       buttonCilkHere.setVisible(true);
                                       backUp.setVisible(false);
                                   });

                               }
                               else if(radioButtonClass.isSelected()){
                                   f1.setVisible(true);
                                   f2.setVisible(true);
                                   b2.setVisible(true);
                                   fill.setVisible(true);
                                   Id.setVisible(true);
                                   backUp.setVisible(true);
                                   fill.setText("Class");
                                   buttonCilkHere.setVisible(false);
                                   b2.setOnAction(event1 -> {
                                       try {
                                           String  q1 = f1.getText();
                                           String q2 = f2.getText();
                                           PreparedStatement query5 = con.prepareStatement("UPDATE SCHEDULE SET CLASS_NUMBER = ? WHERE NUMBER_OF_SUBJECT= ? ");
                                           query5.setString(1,q1);
                                           query5.setString(2,q2);
                                          int count = query5.executeUpdate();
                                          if(count==1){
                                              JOptionPane.showMessageDialog(null,"done");
                                          }
                                       } catch (SQLException throwables) {
                                           throwables.printStackTrace();
                                       }
                                   });
                                   backUp.setOnAction(reset -> {
                                       f1.setVisible(false);
                                       f2.setVisible(false);
                                       b2.setVisible(false);
                                       fill.setVisible(false);
                                       Id.setVisible(false);
                                       buttonCilkHere.setVisible(true);
                                       backUp.setVisible(false);
                                   });

                               }
                               else if(radioButtonTeacher.isSelected()){
                                   f1.setVisible(true);
                                   f2.setVisible(true);
                                   b2.setVisible(true);
                                   fill.setVisible(true);
                                   Id.setVisible(true);
                                   backUp.setVisible(true);
                                   fill.setText("Teacher");
                                   buttonCilkHere.setVisible(false);
                                   b2.setOnAction(event1 -> {
                                       try {
                                           String  q1 = f1.getText();
                                           String q2 = f2.getText();
                                           PreparedStatement query5 = con.prepareStatement("UPDATE SCHEDULE SET NAME_OF_TEACHER = ? WHERE NUMBER_OF_SUBJECT= ? ");
                                           query5.setString(1,q1);
                                           query5.setString(2,q2);
                                           int count = query5.executeUpdate();
                                           if(count==1){
                                               JOptionPane.showMessageDialog(null,"done");
                                           }
                                       } catch (SQLException throwables) {
                                           throwables.printStackTrace();
                                       }

                                   });
                                   backUp.setOnAction(reset -> {
                                       f1.setVisible(false);
                                       f2.setVisible(false);
                                       b2.setVisible(false);
                                       fill.setVisible(false);
                                       Id.setVisible(false);
                                       buttonCilkHere.setVisible(true);
                                       backUp.setVisible(false);

                                   });

                               }
                           } );


                           boxUpdate.getChildren().addAll(radioButtonClass,radioButtonDays,radioButtonTeacher,b);
                           paneUp.getChildren().addAll(viewUp,boxUpdate,buttonCilkHere,backUp,back4);
                           Scene sceneUP = new Scene(paneUp,400,650);
                           Stage stageUp =  new Stage();
                           stageUp.setTitle("Update Page");
                           stageUp.setScene(sceneUP);
                           stageUp.show();
                           stage1.close();
                           back4.setOnMouseClicked(back ->{
                               stageUp.close();
                               stage1.show();
                           });
                       });//EndOfUpdate


                       break;
                   }//endOfSignIn
                   else if (!query.isLast()) {
                       continue;
                   }
                   else {
                       JOptionPane.showMessageDialog(null, "Wrong");
                       break;
                   }

               }
               query.beforeFirst();
           }
           catch (SQLException throwables) {
               throwables.printStackTrace();
           }
        });

    }


    public static void main(String[] args) {
        Application.launch(args);
    }
    public static class Schedule  {
        public  SimpleStringProperty subId; //=new SimpleStringProperty();
        public  SimpleStringProperty nameOfSub ;//= new SimpleStringProperty();
        public  SimpleStringProperty days ;//= new SimpleStringProperty();

        public Schedule() {
        }

        public Schedule(String  subId, String  nameOfSub, String  days) {
            this.subId = new SimpleStringProperty(subId);
            this.nameOfSub =new SimpleStringProperty(nameOfSub);
            this.days = new SimpleStringProperty(days);
        }


        public String getSubId() {
            return subId.get();
        }


        public void setSubId(String subId) {
            this.subId.set(subId);
        }

        public String getNameOfSub() {
            return nameOfSub.get();
        }



        public void setNameOfSub(String nameOfSub) {
            this.nameOfSub.set(nameOfSub);
        }

        public String getDays() {
            return days.get();
        }

        public void setDays(String days) {
            this.days.set(days);
        }
    }
}
