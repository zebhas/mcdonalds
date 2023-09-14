/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

public class Main{
  
  
  public static void main(String[] args){
    
    McDonaldsCLI mcDonaldsCLI = new McDonaldsCLI();
    try {
      mcDonaldsCLI.mainMenu();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
  
}