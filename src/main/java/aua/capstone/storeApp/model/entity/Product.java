package aua.capstone.storeApp.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "product")
public class Product
{
    @Id
    private Integer id;
    private String title;
    private Integer available;
    private Double price;

    public Product()
    {

    }

    public Product(Integer id, String title, Integer available, Double price)
    {
        this.id = id;
        this.title = title;
        this.available = available;
        this.price = price;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Integer getAvailable()
    {
        return available;
    }

    public void setAvailable(Integer available)
    {
        this.available = available;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Product product = (Product) o;

        return Objects.equals(id, product.id) &&
                Objects.equals(title, product.title) &&
                Objects.equals(available, product.available) &&
                Objects.equals(price, product.price);
    }


    @Override
    public int hashCode()
    {

        final int primeMultiplier = 31;

        int result = id != null ? id.hashCode() : 0;

        result = primeMultiplier * result + (title != null ? title.hashCode() : 0);
        result = primeMultiplier * result + (available != null ? available.hashCode() : 0);
        result = primeMultiplier * result + (price != null ? price.hashCode() : 0);

        return result;
    }


    @Override
    public String toString()
    {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", available=" + available +
                ", price=" + price +
                '}';
    }
}
