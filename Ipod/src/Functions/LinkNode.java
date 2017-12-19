/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;
/**
 *
 * @author omero
 */
public class LinkNode {
    
    public String path,name;
    public LinkNode onceki,sonraki;
    
    public LinkNode(String path,String name){
        this.path=path;
        this.name=name;
    }
    
}
