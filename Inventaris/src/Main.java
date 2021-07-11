/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agila
 */
public class Main {
    public static void main(String[] args) {
        ViewData view = new ViewData();
        ModelData model = new ModelData();
        new ControllerData(view, model);
    }
}
