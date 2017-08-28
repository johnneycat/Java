/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebTest;

/**
 *
 * @author wlw
 * 
 * this class is Sql data type in java changge this;
 */
public class SqlDataModel {
    public String name;
    public int age;
    
    public void SetParams(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getAge()
    {
        return String.valueOf(age);
    }
}
