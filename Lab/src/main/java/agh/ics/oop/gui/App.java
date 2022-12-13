package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.FileNotFoundException;

public class App extends Application implements IMapUpdateObserver {
    private GrassField map = new GrassField(10);
    private GridPane grid = new GridPane();
    private final int BOX_SIZE = 19;
    private SimulationEngine engine;
    public void init(){
        Vector2d[] positions = {new Vector2d(3,4)};
        engine = new SimulationEngine(new MoveDirection[0],map,positions);
        engine.addObserver(this);
        Thread thread = new Thread(engine);
    }
    @Override
    public void start(Stage primaryStage) throws Exception, FileNotFoundException{
        TextField text = new TextField("f f l f f f f f f l f f l f f f f l f f f f f f f f f f f");
        Button start = new Button("Start");
        VBox vbox = new VBox(text,start);
        HBox hbox = new HBox(grid,vbox);
        start.setOnAction(click -> {
                engine.setDirections(OptionsParser.parse(text.getText().split(" ")));
            Thread engineThread = new Thread(engine);
            engineThread.start();
        });
        drawMap(map);
        Scene scene = new Scene(hbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void drawMap(IWorldMap map) throws FileNotFoundException {
        Vector2d bound1 = map.getBounds()[0];
        Vector2d bound2 = map.getBounds()[1];
        grid.setGridLinesVisible(true);
        grid.add(new Label("y/x"),0,0,2,1);
        int index = bound1.getY();
        for (int i = 1; i<=bound2.getY()- bound1.getY()+1; i++){
            grid.getRowConstraints().add(new RowConstraints(BOX_SIZE));
            grid.add(new Label((Integer.toString(index))),0, i,1,1);
            index +=1;
        }
        index = bound1.getX();
        for (int i= 1;i<=bound2.getX()- bound1.getX()+1;i++){
            grid.getColumnConstraints().add(new ColumnConstraints(BOX_SIZE));
            grid.add(new Label(Integer.toString(index)),i,0,1,1);
            index+=1;
        }
        int indexX = bound1.getX();
        int indexY = bound1.getY();
        for (int i=1;i<=bound2.getX()- bound1.getX()+1;i++){
            for (int j= 1;j<=bound2.getY()- bound1.getY()+1;j++){
                Object obj = map.objectAt(new Vector2d(indexX,indexY));
                if(obj==null){
                    grid.add(new Label(" "),i,j,1,1);
                }
                else{
                    VBox vbox = new VBox(new GuiElementBox((IMapElement) obj).display());
                    grid.add(vbox,i,j,1,1);
            }
                indexY +=1;
            }
                indexX +=1;
                indexY = bound1.getY();
        }
    }
    private void drawNewMap(IWorldMap newMap) throws FileNotFoundException {
        grid.setGridLinesVisible(false);
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.getChildren().clear();
        map = (GrassField) newMap;
        this.drawMap(map);
    }
    @Override
    public void updateMap(IWorldMap newMap) throws FileNotFoundException {
        Platform.runLater(()->{
            try {
                drawNewMap(map);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
