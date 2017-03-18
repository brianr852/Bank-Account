/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author brian
 */
public class BankAccount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    final double SERVICE_CHARGE_SAVINGS = 10.0 ;
    final double SERVICE_CHARGE_CHECKING = 25.0 ;
    
    final double SAVINGS_INTEREST = 1.04 ;
    final double CHECKING_INTEREST_ONE = 1.03;
    final double CHECKING_INTEREST_TWO = 1.05;
    final double CHECKING_CEILING = 5000.0;
    
    Scanner scan = new Scanner ( System.in ) ;
    
    DecimalFormat pricePattern = new DecimalFormat ( "$#.00" );
    
    System.out.print ( "Please enter the account number > " ) ;
    int accountNumber = scan.nextInt() ;
    
    System.out.print ( "Please enter the account type > " ) ;
    char accountType = scan.next().charAt(0);
    
    System.out.print ( "Please enter the minimum balance > " ) ;
    double minimumBalance = scan.nextDouble();
    
    System.out.print ( "Please enter the current balance > " ) ;
    double currentBalance = scan.nextDouble();
    
    double savingsAccount ;
    double checkingAccount ;
    
    if ( accountType == 'S' || accountType == 's' )
    {
      if ( currentBalance >= minimumBalance )
      {
        savingsAccount = currentBalance * SAVINGS_INTEREST ;
      }
      else
      {
        savingsAccount = currentBalance - SERVICE_CHARGE_SAVINGS ;
        
        System.out.println ( "The current balance is below the minimum, "
                              + "service charge of "
                              + pricePattern.format( SERVICE_CHARGE_SAVINGS ) 
                              + " applied." ) ;
      }      
      System.out.println ( "Account number : " + accountNumber ) ;
      System.out.println ( "Account type   : SAVINGS" ) ;
      System.out.println ( "Minimum balance : " + pricePattern.format( minimumBalance ) ) ;
      System.out.println ( "Current balance : " + pricePattern.format( currentBalance ) ) ;
      System.out.println ( "Ending balance  : " + pricePattern.format( savingsAccount ) ) ;        
    }
    else if ( accountType == 'C' || accountType == 'c' )
    {
      if ( currentBalance >= minimumBalance )
      {
        if ( currentBalance >= ( minimumBalance + CHECKING_CEILING ) )
        {
          checkingAccount = currentBalance * CHECKING_INTEREST_ONE ;
        }
        else
        {
          checkingAccount = currentBalance * CHECKING_INTEREST_TWO ;
        }
      }
      else
      {
        checkingAccount = currentBalance - SERVICE_CHARGE_CHECKING ;
        
        System.out.println ( "The current balance is below the minimum, "
                              + "service charge of "
                              + pricePattern.format( SERVICE_CHARGE_CHECKING ) 
                              + " applied." ) ;
      }
      
      System.out.println ( "Account number  : " + accountNumber ) ;
      System.out.println ( "Account type    : CHECKING" ) ;
      System.out.println ( "Minimum balance : " + pricePattern.format( minimumBalance ) ) ;
      System.out.println ( "Current balance : " + pricePattern.format( currentBalance ) ) ;
      System.out.println ( "Ending balance  : " + pricePattern.format( checkingAccount ) ) ;   
    }
    else
    {
      System.out.println ( "Invalid account type : " + accountType ) ;
    }
    }
    
}
