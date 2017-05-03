package Helper;

import java.util.Arrays;

/**
 * Created by Andrei_Tsyulia on 5/2/2017.
 */
public class Product
{
    private boolean status;
    private String categories[];
    private String defaultCategory;
    private String dateValidFrom;
    private String dateValidTo;
    private String productGroups;
    private String code;
    private String name;
    private String sku;
    private String gtin;
    private String taric;
    private String quantity;
    private String quantityMeasure;
    private String weight;
    private String weightMeasure;
    private String width;
    private String height;
    private String length;
    private String sizeMeasure;
    private String deliveryStatus;
    private String soldOutStatus;
    private String pathOfImage;
    private String manufacturer;
    private String supplier;
    private String keywords;
    private String shortDescription;
    private String description;
    private String attributes;
    private String headTitle;
    private String metaDescription;
    private String purchasePrice;
    private String val;
    private String taxClass;
    private String priceUSD;
    private String priceEUR;

    public Product(boolean status, String[] categories, String defaultCategory, String productGroups, String dateValidFrom,
                   String dateValidTo, String code, String name, String sku, String gtin, String taric, String quantity,
                   String quantityMeasure, String weight, String weightMeasure, String width, String height,
                   String length, String sizeMeasure, String deliveryStatus, String soldOutStatus, String pathOfImage,
                   String manufacturer, String supplier, String keywords, String shortDescription, String description,
                   String attributes, String headTitle, String metaDescription, String purchasePrice, String val,
                   String taxClass, String priceUSD, String priceEUR)
    {
        this.status = status;
        this.categories = categories;
        this.defaultCategory = defaultCategory;
        this.dateValidFrom = dateValidFrom;
        this.dateValidTo = dateValidTo;
        this.productGroups = productGroups;
        this.code = code;
        this.name = name;
        this.sku = sku;
        this.gtin = gtin;
        this.taric = taric;
        this.quantity = quantity;
        this.quantityMeasure = quantityMeasure;
        this.weight = weight;
        this.weightMeasure = weightMeasure;
        this.width = width;
        this.height = height;
        this.length = length;
        this.sizeMeasure = sizeMeasure;
        this.deliveryStatus = deliveryStatus;
        this.soldOutStatus = soldOutStatus;
        this.pathOfImage = pathOfImage;
        this.manufacturer = manufacturer;
        this.supplier = supplier;
        this.keywords = keywords;
        this.shortDescription = shortDescription;
        this.description = description;
        this.attributes = attributes;
        this.headTitle = headTitle;
        this.metaDescription = metaDescription;
        this.purchasePrice = purchasePrice;
        this.val = val;
        this.taxClass = taxClass;
        this.priceUSD = priceUSD;
        this.priceEUR = priceEUR;
    }

    public String getVal()
    {
        return val;
    }

    public void setVal(String val)
    {
        this.val = val;
    }

    public boolean isStatus()
    {
        return status;

    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public String[] getCategories()
    {
        return categories;
    }

    public void setCategories(String[] categorys)
    {
        this.categories = categorys;
    }

    public String getDefaultCategory()
    {
        return defaultCategory;
    }

    public void setDefaultCategory(String defaultCategory)
    {
        this.defaultCategory = defaultCategory;
    }

    public String getDateValidFrom()
    {
        return dateValidFrom;
    }

    public void setDateValidFrom(String dateValidFrom)
    {
        this.dateValidFrom = dateValidFrom;
    }

    public String getDateValidTo()
    {
        return dateValidTo;
    }

    public void setDateValidTo(String dateValidTo)
    {
        this.dateValidTo = dateValidTo;
    }

    public String getProductGroups()
    {
        return productGroups;
    }

    public void setProductGroups(String productGroups)
    {
        this.productGroups = productGroups;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSku()
    {
        return sku;
    }

    public void setSku(String sku)
    {
        this.sku = sku;
    }

    public String getGtin()
    {
        return gtin;
    }

    public void setGtin(String gtin)
    {
        this.gtin = gtin;
    }

    public String getTaric()
    {
        return taric;
    }

    public void setTaric(String taric)
    {
        this.taric = taric;
    }

    public String getQuantity()
    {
        return quantity;
    }

    public void setQuantity(String quantity)
    {
        this.quantity = quantity;
    }

    public String getQuantityMeasure()
    {
        return quantityMeasure;
    }

    public void setQuantityMeasure(String quantityMeasure)
    {
        this.quantityMeasure = quantityMeasure;
    }

    public String getWeight()
    {
        return weight;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    public String getWeightMeasure()
    {
        return weightMeasure;
    }

    public void setWeightMeasure(String weightMeasure)
    {
        this.weightMeasure = weightMeasure;
    }

    public String getWidth()
    {
        return width;
    }

    public void setWidth(String width)
    {
        this.width = width;
    }

    public String getHeight()
    {
        return height;
    }

    public void setHeight(String height)
    {
        this.height = height;
    }

    public String getLength()
    {
        return length;
    }

    public void setLength(String length)
    {
        this.length = length;
    }

    public String getSizeMeasure()
    {
        return sizeMeasure;
    }

    public void setSizeMeasure(String sizeMeasure)
    {
        this.sizeMeasure = sizeMeasure;
    }

    public String getDeliveryStatus()
    {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus)
    {
        this.deliveryStatus = deliveryStatus;
    }

    public String getSoldOutStatus()
    {
        return soldOutStatus;
    }

    public void setSoldOutStatus(String soldOutStatus)
    {
        this.soldOutStatus = soldOutStatus;
    }

    public String getPathOfImage()
    {
        return pathOfImage;
    }

    public void setPathOfImage(String pathOfImage)
    {
        this.pathOfImage = pathOfImage;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public String getSupplier()
    {
        return supplier;
    }

    public void setSupplier(String supplier)
    {
        this.supplier = supplier;
    }

    public String getKeywords()
    {
        return keywords;
    }

    public void setKeywords(String keywords)
    {
        this.keywords = keywords;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription)
    {
        this.shortDescription = shortDescription;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getAttributes()
    {
        return attributes;
    }

    public void setAttributes(String attributes)
    {
        this.attributes = attributes;
    }

    public String getHeadTitle()
    {
        return headTitle;
    }

    public void setHeadTitle(String headTitle)
    {
        this.headTitle = headTitle;
    }

    public String getMetaDescription()
    {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription)
    {
        this.metaDescription = metaDescription;
    }

    public String getPurchasePrice()
    {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice)
    {
        this.purchasePrice = purchasePrice;
    }

    public String getTaxClass()
    {
        return taxClass;
    }

    public void setTaxClass(String taxClass)
    {
        this.taxClass = taxClass;
    }

    public String getPriceUSD()
    {
        return priceUSD;
    }

    public void setPriceUSD(String priceUSD)
    {
        this.priceUSD = priceUSD;
    }

    public String getPriceEUR()
    {
        return priceEUR;
    }

    public void setPriceEUR(String priceEUR)
    {
        this.priceEUR = priceEUR;
    }

    @Override
    public String toString()
    {
        return "Product{" +
            "status=" + status +
            ", categorys=" + Arrays.toString(categories) +
            ", defaultCategory='" + defaultCategory + '\'' +
            ", dateValidFrom='" + dateValidFrom + '\'' +
            ", dateValidTo='" + dateValidTo + '\'' +
            ", productGroups='" + productGroups + '\'' +
            ", code='" + code + '\'' +
            ", name='" + name + '\'' +
            ", sku='" + sku + '\'' +
            ", gtin='" + gtin + '\'' +
            ", taric='" + taric + '\'' +
            ", quantity='" + quantity + '\'' +
            ", quantityMeasure='" + quantityMeasure + '\'' +
            ", weight='" + weight + '\'' +
            ", weightMeasure='" + weightMeasure + '\'' +
            ", width='" + width + '\'' +
            ", height='" + height + '\'' +
            ", length='" + length + '\'' +
            ", sizeMeasure='" + sizeMeasure + '\'' +
            ", deliveryStatus='" + deliveryStatus + '\'' +
            ", soldOutStatus='" + soldOutStatus + '\'' +
            ", pathOfImage='" + pathOfImage + '\'' +
            ", manufacturer='" + manufacturer + '\'' +
            ", supplier='" + supplier + '\'' +
            ", keywords='" + keywords + '\'' +
            ", shortDescription='" + shortDescription + '\'' +
            ", description='" + description + '\'' +
            ", attributes='" + attributes + '\'' +
            ", headTitle='" + headTitle + '\'' +
            ", metaDescription='" + metaDescription + '\'' +
            ", purchasePrice='" + purchasePrice + '\'' +
            ", val='" + val + '\'' +
            ", taxClass='" + taxClass + '\'' +
            ", priceUSD='" + priceUSD + '\'' +
            ", priceEUR='" + priceEUR + '\'' +
            '}';
    }
}
