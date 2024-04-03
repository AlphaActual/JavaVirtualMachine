package hr.unipu.java;

// apstraktna klasa koja služi za nasljeđivanje i ima implentirano ranije deklarirano sučelje Question
public abstract class AbstractQuestion implements Question {
    private String text;    // atribut, koji će se kasnije nasljeđivati

    // konstruktor, on će se u nasljeđenim klasama pozivati sa super(text)
    public AbstractQuestion(String text) {
        this.text = text;
    }

    // implementacija metode, što će se kasnije nasljeđivati
    public String getText() {
        return text;
    }

    // apstraktna metoda, koja će imati konkretnu implementaciju tek u nasljeđenim klasama
    public abstract boolean isCorrectAnswer(String answer);

    // Overrding equals iz klase Object
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof AbstractQuestion))
            return false;

        AbstractQuestion other = (AbstractQuestion) obj;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result +
                ((text == null) ? 0 : text.hashCode());
        return result;
    }



}
