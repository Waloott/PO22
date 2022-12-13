package agh.ics.oop.gui;
import agh.ics.oop.IMapElement;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private VBox vbox;
public GuiElementBox(IMapElement mapElement) throws FileNotFoundException {
    Image img = new Image(new FileInputStream(mapElement.getImgSource()));
    ImageView imgView = new ImageView(img);
    imgView.setFitHeight(20);
    imgView.setFitWidth(20);
    vbox = new VBox(imgView);
}
public VBox display(){
return this.vbox;
}
}
