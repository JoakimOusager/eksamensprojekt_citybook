package gui.Tableviews.objects;

/**
 * Created by Daniel on 19-05-2017.
 */
public class Aktivitet {


    private String comment;
    private String virksomhed;
    private String contact;
    private String date;

    public Aktivitet(String comment, String virksomhed, String contact, String date) {
        this.comment = comment;
        this.virksomhed = virksomhed;
        this.contact = contact;
        this.date = date;
    }

    public Aktivitet() {
        this.comment = "";
        this.virksomhed = "";
        this.contact = "";
        this.date = "";
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getVirksomhed() {
        return virksomhed;
    }

    public void setVirksomhed(String virksomhed) {
        this.virksomhed = virksomhed;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
