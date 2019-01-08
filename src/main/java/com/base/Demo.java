package com.base;

/**
 * @author gzd
 * @create 2018-11-02 9:57
 * @desc
 **/
public class Demo {

    /* public int hashcode(){
         return 0;
     }*/
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Demo() {
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result =1;
        result = PRIME * result +getId();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (obj == this){
            return true;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Demo d = (Demo) obj;
        return (this.getId() == d.getId());

    }
}
