package com.am.Controller;

import com.am.Main;
import com.am.Model.Fruit;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class ItemController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label itlabel;

    @FXML
    private Label priceLabel;

    @FXML
    private ImageView img;

    private Fruit fruit;

    private MyListener myListener;

    @FXML
    private void click(MouseEvent mouseEvent){
        myListener.onFruitClickListener(fruit);
    }

    public void setFruit(Fruit fruit,MyListener myListener) {
        this.fruit = fruit;
        this.myListener = myListener;
        nameLabel.setText(fruit.getName());
        priceLabel.setText(Main.currency + fruit.getPrice());
        Image image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        img.setImage(image);
    }
}
