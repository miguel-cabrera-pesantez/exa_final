package com.example.exa_final;

import java.util.List;

public class Responseproducto {
    private boolean status;
    private List<Product> objects;

    public Responseproducto() {
    }

    public Responseproducto(boolean status, List<Product> objects) {
        this.status = status;
        this.objects = objects;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Product> getObjects() {
        return objects;
    }

    public void setObjects(List<Product> objects) {
        this.objects = objects;
    }
}
