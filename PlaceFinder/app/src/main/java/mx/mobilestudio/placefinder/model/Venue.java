
package mx.mobilestudio.placefinder.model;

import java.util.List;

public class Venue {

    private String id;
    private String name;
    private Contact contact;
    private Location location;
    private List<Category> categories = null;
    private Boolean verified;
    private Stats stats;
    private Boolean allowMenuUrlEdit;
    private BeenHere beenHere;
    private Specials specials;
    private HereNow hereNow;
    private String referralId;
    private List<Object> venueChains = null;
    private Boolean hasPerk;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Boolean getAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    public void setAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    public BeenHere getBeenHere() {
        return beenHere;
    }

    public void setBeenHere(BeenHere beenHere) {
        this.beenHere = beenHere;
    }

    public Specials getSpecials() {
        return specials;
    }

    public void setSpecials(Specials specials) {
        this.specials = specials;
    }

    public HereNow getHereNow() {
        return hereNow;
    }

    public void setHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public List<Object> getVenueChains() {
        return venueChains;
    }

    public void setVenueChains(List<Object> venueChains) {
        this.venueChains = venueChains;
    }

    public Boolean getHasPerk() {
        return hasPerk;
    }

    public void setHasPerk(Boolean hasPerk) {
        this.hasPerk = hasPerk;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
