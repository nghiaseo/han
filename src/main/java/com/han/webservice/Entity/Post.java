package com.han.webservice.Entity;
import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    private  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private  String title;
    private  String content;
    Post(){}
    Post(String title,String content){
        this.title = title;
        this.content = content;
    }
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public  String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getContent(){
        return this.content;
    }
    public void setContent(String content){
        this.content = content;
    }
}
