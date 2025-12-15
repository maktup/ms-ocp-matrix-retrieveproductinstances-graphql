package org.acme.graphql.mapper;

import com.itelcorp.product.dto.*;
import io.vertx.core.json.Json;
import org.acme.graphql.types.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Conversión desde DTOs REST a DTOs GraphQL.
 */
public final class ProductMapper {

    private ProductMapper() {
    }

    public static Product toGraphQL(ProductInstanceType rest) {
        if (rest == null) {
            return null;
        }
        Product product = new Product();
        
        // Campos básicos
        product.setId(rest.getId());
        product.setPublicId(rest.getPublicId());
        product.setName(rest.getName());
        product.setDescription(rest.getDescription());
        product.setProductType(rest.getProductType() != null ? rest.getProductType().value() : null);
        product.setStatus(rest.getStatus() != null ? rest.getStatus().value() : null);
        product.setSubStatus(rest.getSubStatus());
        product.setHref(rest.getHref());
        product.setIsBundle(rest.getIsBundle());
        product.setStartDate(rest.getStartDate());
        product.setTerminationDate(rest.getTerminationDate());
        product.setOrderDate(rest.getOrderDate());
        product.setTags(rest.getTags());
        
        // Características
        product.setCharacteristic(rest.getCharacteristic() == null
                ? List.of()
                : rest.getCharacteristic().stream()
                .map(ProductMapper::toCharacteristic)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
        
        // Billing Account
        product.setBillingAccount(rest.getBillingAccount() == null
                ? List.of()
                : rest.getBillingAccount().stream()
                .map(ProductMapper::toBillingAccount)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
        
        // Product Offering
        if (rest.getProductOffering() != null) {
            product.setProductOffering(toEntityRef(rest.getProductOffering()));
        }
        
        // Product Spec
        if (rest.getProductSpec() != null) {
            product.setProductSpec(toEntityRef(rest.getProductSpec()));
        }
        
        // Place
        product.setPlace(rest.getPlace() == null
                ? List.of()
                : rest.getPlace().stream()
                .map(ProductMapper::toPlace)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
        
        // Related Party
        product.setRelatedParty(rest.getRelatedParty() == null
                ? List.of()
                : rest.getRelatedParty().stream()
                .map(ProductMapper::toRelatedParty)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
        
        // Product Price
        product.setProductPrice(rest.getProductPrice() == null
                ? List.of()
                : rest.getProductPrice().stream()
                .map(ProductMapper::toProductPrice)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
        
        // Product Relationship
        product.setProductRelationship(rest.getProductRelationship() == null
                ? List.of()
                : rest.getProductRelationship().stream()
                .map(ProductMapper::toProductRelationship)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
        
        return product;
    }

    // ==================== Billing Account ====================
    
    public static BillingAccount toBillingAccount(AccountRefType rest) {
        if (rest == null) {
            return null;
        }
        BillingAccount ba = new BillingAccount();
        ba.setId(rest.getId());
        ba.setName(rest.getName());
        ba.setHref(rest.getHref());
        ba.setBillingMethod(rest.getBillingMethod() != null ? rest.getBillingMethod().value() : null);
        ba.setReferredType(rest.getAtReferredType());
        return ba;
    }

    // ==================== Entity Ref ====================
    
    public static EntityRef toEntityRef(EntityRefType rest) {
        if (rest == null) {
            return null;
        }
        EntityRef ref = new EntityRef();
        ref.setId(rest.getId());
        ref.setName(rest.getName());
        ref.setHref(rest.getHref());
        ref.setDescription(rest.getDescription());
        ref.setEntityType(rest.getEntityType());
        ref.setReferredType(rest.getAtReferredType());
        return ref;
    }

    // ==================== Place ====================
    
    public static Place toPlace(PlaceRefType rest) {
        if (rest == null) {
            return null;
        }
        Place place = new Place();
        place.setId(rest.getId());
        place.setName(rest.getName());
        place.setHref(rest.getHref());
        place.setDescription(rest.getDescription());
        place.setRole(rest.getRole());
        place.setEntityType(rest.getEntityType());
        place.setReferredType(rest.getAtReferredType());
        
        if (rest.getCoordinates() != null) {
            place.setCoordinates(toCoordinates(rest.getCoordinates()));
        }
        if (rest.getDepartment() != null) {
            place.setDepartment(toLocaleRef(rest.getDepartment()));
        }
        if (rest.getProvince() != null) {
            place.setProvince(toLocaleRef(rest.getProvince()));
        }
        if (rest.getDistrict() != null) {
            place.setDistrict(toLocaleRef(rest.getDistrict()));
        }
        
        return place;
    }
    
    public static Coordinates toCoordinates(CoordinatesType rest) {
        if (rest == null) {
            return null;
        }
        Coordinates coords = new Coordinates();
        coords.setLatitude(rest.getLatitude());
        coords.setLongitude(rest.getLongitude());
        return coords;
    }
    
    public static LocaleRef toLocaleRef(LocaleRefType rest) {
        if (rest == null) {
            return null;
        }
        LocaleRef locale = new LocaleRef();
        locale.setCode(rest.getCode());
        locale.setDescription(rest.getDescription());
        return locale;
    }

    // ==================== Related Party ====================
    
    public static RelatedParty toRelatedParty(RelatedPartyRefType rest) {
        if (rest == null) {
            return null;
        }
        RelatedParty party = new RelatedParty();
        party.setId(rest.getId());
        party.setName(rest.getName());
        party.setHref(rest.getHref());
        party.setDescription(rest.getDescription());
        party.setRole(rest.getRole());
        party.setNationalId(rest.getNationalId());
        party.setNationalIdType(rest.getNationalIdType());
        party.setReferredType(rest.getAtReferredType());
        return party;
    }

    // ==================== Product Price ====================
    
    public static ProductPrice toProductPrice(ComponentProdPriceType rest) {
        if (rest == null) {
            return null;
        }
        ProductPrice pp = new ProductPrice();
        pp.setId(rest.getId());
        pp.setName(rest.getName());
        pp.setDescription(rest.getDescription());
        pp.setPriceType(rest.getPriceType() != null ? rest.getPriceType().value() : null);
        pp.setRecurringChargePeriod(rest.getRecurringChargePeriod() != null ? rest.getRecurringChargePeriod().value() : null);
        pp.setTaxIncluded(rest.getTaxIncluded());
        pp.setTaxRate(rest.getTaxRate());
        pp.setTaxType(rest.getTaxType());
        pp.setIsMandatory(rest.getIsMandatory());
        
        if (rest.getPrice() != null) {
            pp.setPrice(toMoney(rest.getPrice()));
        }
        
        return pp;
    }
    
    public static Money toMoney(MoneyType rest) {
        if (rest == null) {
            return null;
        }
        Money money = new Money();
        money.setAmount(rest.getAmount());
        money.setCurrency(rest.getUnits());
        return money;
    }

    // ==================== Product Relationship ====================
    
    public static ProductRelationship toProductRelationship(RelatedProductType rest) {
        if (rest == null) {
            return null;
        }
        ProductRelationship rel = new ProductRelationship();
        rel.setType(rest.getType());
        
        if (rest.getProduct() != null) {
            rel.setProduct(toRelatedProduct(rest.getProduct()));
        }
        
        return rel;
    }
    
    public static RelatedProduct toRelatedProduct(ProductRefInfoType rest) {
        if (rest == null) {
            return null;
        }
        RelatedProduct rp = new RelatedProduct();
        rp.setId(rest.getId());
        rp.setPublicId(rest.getPublicId());
        rp.setName(rest.getName());
        rp.setDescription(rest.getDescription());
        rp.setProductType(rest.getProductType() != null ? rest.getProductType().value() : null);
        rp.setHref(rest.getHref());
        
        // Características del producto relacionado
        rp.setCharacteristic(rest.getCharacteristic() == null
                ? List.of()
                : rest.getCharacteristic().stream()
                .map(ProductMapper::toCharacteristic)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
        
        // Relaciones anidadas (recursivo)
        rp.setProductRelationship(rest.getProductRelationship() == null
                ? List.of()
                : rest.getProductRelationship().stream()
                .map(ProductMapper::toProductRelationship)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
        
        return rp;
    }

    // ==================== Product Characteristic (existente) ====================

    public static ProductCharacteristic toCharacteristic(ProductCharacteristicType rest) {
        if (rest == null) {
            return null;
        }
        if (rest instanceof StringType s) {
            StringCharacteristic target = new StringCharacteristic();
            target.setCode(s.getCode());
            target.setName(s.getName());
            target.setValue(s.getValue());
            return target;
        }
        if (rest instanceof Text t) {
            TextCharacteristic target = new TextCharacteristic();
            target.setCode(t.getCode());
            target.setName(t.getName());
            target.setValue(t.getValue());
            return target;
        }
        if (rest instanceof MobileQuota m) {
            return mapMobileQuota(m);
        }
        if (rest instanceof InternetConnection internet) {
            InternetConnectionCharacteristic target = new InternetConnectionCharacteristic();
            target.setCode(internet.getCode());
            target.setValueJson(internet.getValue() != null ? Json.encode(internet.getValue()) : null);
            return target;
        }
        if (rest instanceof TvPackages tv) {
            TvPackagesCharacteristic target = new TvPackagesCharacteristic();
            target.setCode(tv.getCode());
            target.setValueJson(tv.getValue() != null ? Json.encode(tv.getValue()) : null);
            return target;
        }
        return null;
    }

    private static MobileQuotaCharacteristic mapMobileQuota(MobileQuota rest) {
        MobileQuotaCharacteristic target = new MobileQuotaCharacteristic();
        target.setCode(rest.getCode());

        MobileQuotaValue value = new MobileQuotaValue();
        MobileQuotaCharacteristicType rawValue = rest.getValue();
        if (rawValue != null) {
            value.setVoiceQuota(mapVoiceQuotas(rawValue.getVoiceQuota()));
            value.setDataQuota(mapDataQuotas(rawValue.getDataQuota()));
            value.setSmsQuota(mapSmsQuotas(rawValue.getSmsQuota()));
        }
        target.setQuotaValue(value);
        return target;
    }

    private static List<VoiceQuota> mapVoiceQuotas(List<VoiceQuotaType> source) {
        if (source == null) return List.of();
        return source.stream().map(s -> {
            VoiceQuota v = new VoiceQuota();
            v.setVoiceAllowance(s.getVoiceAllowance());
            v.setUnit(s.getUnit());
            v.setTimeBands(s.getTimeBands());
            v.setOrigins(s.getOrigins());
            v.setDestinations(s.getDestinations());
            return v;
        }).collect(Collectors.toList());
    }

    private static List<DataQuota> mapDataQuotas(List<DataQuotaType> source) {
        if (source == null) return List.of();
        return source.stream().map(s -> {
            DataQuota d = new DataQuota();
            d.setDataAllowance(s.getDataAllowance());
            d.setUnit(s.getUnit());
            d.setTimeBands(s.getTimeBands());
            d.setOrigins(s.getOrigins());
            d.setDestinations(s.getDestinations());
            return d;
        }).collect(Collectors.toList());
    }

    private static List<SmsQuota> mapSmsQuotas(List<SmsQuotaType> source) {
        if (source == null) return List.of();
        return source.stream().map(s -> {
            SmsQuota sms = new SmsQuota();
            sms.setSmsAllowance(s.getSmsAllowance());
            sms.setTimeBands(s.getTimeBands());
            sms.setOrigins(s.getOrigins());
            sms.setDestinations(s.getDestinations());
            return sms;
        }).collect(Collectors.toList());
    }
}
