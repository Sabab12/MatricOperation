package com.bgmea.matricoperation;

import java.util.Arrays;

public class Matrix {

    int[][] vals;


    public Matrix(int[][] vals) {
        this.vals = vals;
    }

    public Matrix(int row, int col) {
        this.vals = new int[row][col];
    }

    public int[][] getVals() {
        return vals;
    }

    public Matrix transpose() {
        Matrix transposedMatrix = new Matrix(this.vals[0].length, this.vals.length);
        for (int i = 0; i < this.vals.length; i++) {
            for (int j = 0; j < this.vals[i].length; j++) {
                transposedMatrix.vals[j][i] = this.vals[i][j];
            }
        }
        return transposedMatrix;
    }


    @Override
    public String toString() {
        String str = " ";
        int i, j;
        for (i = 0; i < vals.length; i++) {
            for (j = 0; j < vals[i].length; j++) {
                str += vals[i][j] + " ";
            }
            str += "\n\n";

        }
        return str;
    }

    public Matrix sub(Matrix m) {
        Matrix temp = null;
        if (this.vals.length == m.vals.length &&

                this.vals[0].length == m.vals.length) {
            temp = new Matrix(this.vals.length, this.vals[0].length);
            int i, j;
            for (i = 0; i < vals.length; i++) {
                for (j = 0; j < vals[i].length; j++) {
                    temp.vals[i][j] = this.vals[i][j] - m.vals[i][j];


                }


            }


        }
        return temp;
    }


    public void setVals(int[][] vals) {
        this.vals = vals;
    }

    public Matrix add(Matrix m) {
        Matrix temp = null;
        if (this.vals.length == m.vals.length &&

                this.vals[0].length == m.vals.length) {
            temp = new Matrix(this.vals.length, this.vals[0].length);
            int i, j;
            for (i = 0; i < vals.length; i++) {
                for (j = 0; j < vals[i].length; j++) {
                    temp.vals[i][j] = this.vals[i][j] + m.vals[i][j];

                }
            }


        }
        return temp;

    }

    public Matrix multiply(Matrix perameter) {

        if (this.vals.length != perameter.vals[0].length) {

            return null;
        }
        Matrix temp = new Matrix(this.vals.length, this.vals[0].length);
        int i, j;
        for (i = 0; i < this.vals.length; i++) {
            for (j = 0; j < perameter.vals[0].length; j++) {

                int sum = 0;
                int k;
                for (k = 0; k < this.vals[0].length;k++) {
                    sum += this.vals[i][k] * perameter.vals[k][j];
                }

                temp.vals[i][j] = sum;

            }




        }

        return temp;
    }
}
