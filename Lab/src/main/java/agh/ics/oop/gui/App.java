package agh.ics.oop.gui;
import agh.ics.oop.Animal;
import agh.ics.oop.GrassField;
import agh.ics.oop.Vector2d;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
public class App extends Application{

//niestety nie zdążyłem dokończyć zadań

    @Override
    public void start(Stage primaryStage) throws Exception{
        Label label = new Label("Zwierzak");
        GrassField map = new GrassField(10);
        Vector2d x = map.getBounds()[0];
        Vector2d y = map.getBounds()[1];
        GridPane grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(15));
        grid.getRowConstraints().add(new RowConstraints(15));
        Animal a  = new Animal(map,new Vector2d(2,1));
        map.place(a);
        System.out.println(x.x);

        grid.add(new Label("y/x"),0,0,2,1);
        for (int i=1;i<=9;i++){
            grid.getColumnConstraints().add(new ColumnConstraints(15));
            grid.getRowConstraints().add(new RowConstraints(15));
            grid.add(new Label((Integer.toString(i))),0, i,1,1);
        }
        for (int i=1;i<=9;i++){
            grid.add(new Label(Integer.toString(i)),i,0,1,1);
        }
        for (int i=1;i<=9;i++){
            for (int j=1;j<9;j++){
                Object obj = map.objectAt(new Vector2d(i,j));
                if(obj==null){
                    grid.add(new Label(" "),i,j,1,1);
                }
                else{
                grid.add(new Label(obj.toString()),i,j,1,1);
            }
        }}
        grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
