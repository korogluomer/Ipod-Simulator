/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import java.io.File;

/**
 *
 * @author omero
 */
public class Lists {
    
    private LinkNode headNode,tailNode;
    private LinkNode y;
    
    public Lists(){
        headNode=null;
        tailNode=null;
    }
    
    public void Add(String data,String name){
        LinkNode yeniNode=new LinkNode(data,name);
        if(headNode==null){
            headNode=yeniNode;
            tailNode=yeniNode;
            headNode.onceki=null;
            headNode.sonraki=null;
            tailNode.onceki=null;
            tailNode.sonraki=null;            
        }
        else if(headNode.sonraki==null){
            headNode.sonraki=yeniNode;
            headNode.onceki=yeniNode;
            tailNode=yeniNode;
            tailNode.sonraki=headNode;
            tailNode.onceki=headNode;
        }
        else{
            tailNode.sonraki=yeniNode;
            yeniNode.onceki=tailNode;
            headNode.onceki=yeniNode;
            yeniNode.sonraki=headNode;
            tailNode=yeniNode;
        }
    }
    
    public void search(){
        File dir=new File("./music");
        File []list=dir.listFiles();
        for(File file:list){
            if(file.getName().endsWith(".wav")){
                Add(file.getAbsolutePath(),file.getName());
            }
        }
        
        y=headNode;
    }
    public void Listeleileri(){
        y=y.sonraki;
    }
    public void Listelegeri(){
        y=y.onceki;
    }

    public LinkNode getHeadNode() {
        return headNode;
    }

    public LinkNode getTailNode() {
        return tailNode;
    }

    public LinkNode getY() {
        return y;
    }
}
