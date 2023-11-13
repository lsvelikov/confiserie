package com.example.confiserie.model.enums;

public enum CategoryEnum {

    JAM("Jam is a thick, gelatinous mixture of chopped or mashed fruit, pectin and sugar that's boiled until the fruit is soft, but still holds its shape, and obtains a semi-firm, spreadable consistency. Jams' spreadable consistency make it a great topping for toast, biscuits, bread and scones."),
    TRUFFLE("A traditional chocolate truffle is a confectionery made with a rich chocolate ganache center. They're shaped by hand into spheres or balls, which is why they get their name from the edible fungus we know as truffles. They don't taste like mushrooms, but they look like one!"),
    CAKE("A sweet baked food made from a dough or thick batter usually containing flour and sugar and often shortening, eggs, and a raising agent (such as baking powder)"),
    TART("A tart is a baked dish consisting of a filling over a pastry base with an open top not covered with pastry."),
    MACARONS("It's a sweet meringue, a delicate duet of two cookies that share a filling of almonds, buttercream, ganache, jams, powdered sugar, and egg whites. The shells are crispy from the outside, and chewy and soft from this inside, so moist that it dissolves in your mouth.");

    private final String value;
    CategoryEnum (String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
