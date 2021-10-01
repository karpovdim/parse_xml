package by.karpov.models;

import java.math.BigDecimal;

public class Software implements Comparable<Software>{
    private String typeSoftware;
    private String name;
    private  String version;
    private Integer  size;
    private BigDecimal price;

    public Software() {
    }

    public String getTypeSoftware() {
        return this.typeSoftware;
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public Integer getSize() {
        return this.size;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setTypeSoftware(String typeSoftware) {
        this.typeSoftware = typeSoftware;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Software)) return false;
        final Software other = (Software) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$typeSoftware = this.getTypeSoftware();
        final Object other$typeSoftware = other.getTypeSoftware();
        if (this$typeSoftware == null ? other$typeSoftware != null : !this$typeSoftware.equals(other$typeSoftware))
            return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$version = this.getVersion();
        final Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) return false;
        final Object this$size = this.getSize();
        final Object other$size = other.getSize();
        if (this$size == null ? other$size != null : !this$size.equals(other$size)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Software;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $typeSoftware = this.getTypeSoftware();
        result = result * PRIME + ($typeSoftware == null ? 43 : $typeSoftware.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $version = this.getVersion();
        result = result * PRIME + ($version == null ? 43 : $version.hashCode());
        final Object $size = this.getSize();
        result = result * PRIME + ($size == null ? 43 : $size.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        return result;
    }

    public String toString() {
        return "\n Software(typeSoftware=" + this.getTypeSoftware() + ",\n name=" + this.getName() + ",\n version=" + this.getVersion() + ",\n size=" + this.getSize() + ",\n price=" + this.getPrice() + ")";
    }

    @Override
    public int compareTo(Software software) {
        return Integer.compare(this.size,software.size);

    }

}
