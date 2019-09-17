package cn.chenzw.springboot.two.domain.entity;

/**
 * Java基本数据类型实体
 *
 * @author chenzw
 */
public class TypesEntity {
    private Byte byteType;
    private Boolean booleanType;
    private Short shortType;
    private Character characterType;
    private Integer integerType;
    private Float floatType;
    private Long longType;
    private Double doubleType;

    public Byte getByteType() {
        return byteType;
    }

    public void setByteType(Byte byteType) {
        this.byteType = byteType;
    }

    public Boolean getBooleanType() {
        return booleanType;
    }

    public void setBooleanType(Boolean booleanType) {
        this.booleanType = booleanType;
    }

    public Short getShortType() {
        return shortType;
    }

    public void setShortType(Short shortType) {
        this.shortType = shortType;
    }

    public Character getCharacterType() {
        return characterType;
    }

    public void setCharacterType(Character characterType) {
        this.characterType = characterType;
    }

    public Integer getIntegerType() {
        return integerType;
    }

    public void setIntegerType(Integer integerType) {
        this.integerType = integerType;
    }

    public Float getFloatType() {
        return floatType;
    }

    public void setFloatType(Float floatType) {
        this.floatType = floatType;
    }

    public Long getLongType() {
        return longType;
    }

    public void setLongType(Long longType) {
        this.longType = longType;
    }

    public Double getDoubleType() {
        return doubleType;
    }

    public void setDoubleType(Double doubleType) {
        this.doubleType = doubleType;
    }


    @Override
    public String toString() {
        return "TypesEntity{" + "byteType=" + byteType + ", booleanType=" + booleanType + ", shortType=" + shortType
                + ", characterType=" + characterType + ", integerType=" + integerType + ", floatType=" + floatType
                + ", longType=" + longType + ", doubleType=" + doubleType + '}';
    }
}
