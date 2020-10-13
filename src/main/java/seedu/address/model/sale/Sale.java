package seedu.address.model.sale;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Sale in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Sale {
    // Identity field
    private final ItemName itemName;

    // Data fields
    private final Quantity quantity;
    private final UnitPrice unitPrice;

    // Sale tags
    private final Set<Tag> tags;

    /**
     * Every field must be present and not null.
     */
    public Sale(ItemName itemName, Quantity quantity, UnitPrice unitPrice, Set<Tag> tags) {
        requireAllNonNull(itemName, quantity, unitPrice);
        this.itemName = itemName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.tags = tags;
    }

    public ItemName getItemName() {
        return itemName;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public UnitPrice getUnitPrice() {
        return unitPrice;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }


    /**
     * Returns true if both sales have the same name or are the same.
     * This defines a weaker notion of equality between two sales.
     */
    public boolean isSameSale(Sale otherSale) {
        if (otherSale == this) {
            return true;
        }

        return otherSale != null && otherSale.getItemName().equals(getItemName());
    }

    /**
     * Returns true if both sale have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Sale)) {
            return false;
        }

        Sale otherSale = (Sale) other;
        return otherSale.getItemName().equals(getItemName())
                && otherSale.getQuantity().equals(getQuantity())
                && otherSale.getUnitPrice().equals(getUnitPrice())
                && otherSale.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(itemName, quantity, unitPrice);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getItemName())
                .append(" (Quantity: ")
                .append(getQuantity())
                .append(", ")
                .append(" Unit Price: ")
                .append(getUnitPrice())
                .append(", ")
                .append(" Tags: ")
                .append(getTags())
                .append(")");
        return builder.toString();
    }
}
