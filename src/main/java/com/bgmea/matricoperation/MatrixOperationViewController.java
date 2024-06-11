package com.bgmea.matricoperation;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class MatrixOperationViewController
{
    @javafx.fxml.FXML

    private TextField noOfRow1stMatrix;
    @javafx.fxml.FXML
    private TextField noOfCol1stMatrix;
    @javafx.fxml.FXML
    private Label displayResultComboBox;
    @javafx.fxml.FXML
    private TextField noOfCol2ndMatrix;
    @javafx.fxml.FXML
    private TextField addElementFor1stmatrix;
    @javafx.fxml.FXML
    private TextField noOfRow2ndMatrix;
    @javafx.fxml.FXML
    private ComboBox<String> selectOperationComboBox;
   Matrix m1=null,m2=null,m3,m4;
   int rowInx, colInx;
    @javafx.fxml.FXML
    public void initialize() {
        rowInx=colInx=0;

         selectOperationComboBox.getItems().addAll("Addition","Substruction","Transpose","Multiply");
    }
////////Sabab joy bangla;

    //come to bd
    @javafx.fxml.FXML
    public void executeOperationOnAction(ActionEvent actionEvent) {

        String selectedOperation=selectOperationComboBox.getValue();
        if(selectedOperation.equals("Addition")){
            m3=m1.add(m2);
            displayResultComboBox.setText(
                    "1st Matrix\n "+ m1.toString() +
                      "2nd Matrix\n\n"+ m2.toString()+
                      "result\n\n"+m3.toString());

        } else if (selectedOperation.equals("Substruction")) {
            m3=m2.sub(m1);
            displayResultComboBox.setText(
                    "Matrix-1 \n\n"+ m1.toString()+
                            "Matrix-2\n\n"+m2.toString()+
                            "Result\n\n" +m3.toString()

            );

        }else if(selectedOperation.equals("Transpose")){
            m3=m1.transpose();
            m4=m2.transpose();

             displayResultComboBox.setText(
                     "1st Matrix\n\n"+ m1 +"Transpose of 1st Matrix\n" +m3+
                             "2nd Matrix\n\n"+ m2 +"Transpose of 1st Matrix\n" +m4


             );
        }else if(selectedOperation.equals("Multiply")){
              m3=m1.multiply(m2);
              displayResultComboBox.setText(

                      "Matrix 1\n"+ m1.toString()+
                              "Matrix 2\n" +m2.toString()+
                              "result\n" +m3.toString()
              );
        }
    }

    @javafx.fxml.FXML
    public void generateRandomOnClick(ActionEvent actionEvent) {

        if (m2==null)
         m2=new Matrix(Integer.parseInt(noOfRow2ndMatrix.getText()),
                Integer.parseInt(noOfCol2ndMatrix.getText()));

        int i,j;
        Random r=new Random();
        for(i=0;i<m2.vals.length;i++){
            for(j=0; j<m2.vals[i].length;j++){
                m2.vals[i][j]=r.nextInt(100);

            }
        }

    }

    @javafx.fxml.FXML
    public void addElementOnActionButtonClick(ActionEvent actionEvent) {

        if(m1==null)

         m1=new Matrix(Integer.parseInt(noOfRow1stMatrix.getText()),
                 Integer.parseInt(noOfCol1stMatrix.getText()));


        if (colInx==m1.vals[0].length-1 && rowInx==m1.vals.length-1){
            displayResultComboBox.setText("Matrix OverFlow");
            return;}
     m1.vals[rowInx][colInx]=Integer.parseInt(addElementFor1stmatrix.getText());



    if(colInx<m1.vals[0].length-1){
        colInx++;
    } else if (colInx==m1.vals[0].length-1) {
        if(rowInx<m1.vals.length-1){
            rowInx++;colInx=0;


        } else if (rowInx==m1.vals.length-1) {
                 displayResultComboBox.setText("Matrix OverFlow");

        }

    }


    }
}