package com.example.exa_final;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Product implements Parcelable {

    private int id;
    private String name;
    private String price;
    private String avatar;
    private String created_at;
    private String updated_at;

    public Product() {
    }

    protected Product(Parcel in) {
        id = in.readInt();
        name = in.readString();
        price = in.readString();
        avatar = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(price);
        dest.writeString(avatar);
        dest.writeString(created_at);
        dest.writeString(updated_at);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id && name.equals(product.name) && price.equals(product.price) && avatar.equals(product.avatar) && created_at.equals(product.created_at) && updated_at.equals(product.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, avatar, created_at, updated_at);
    }
}
