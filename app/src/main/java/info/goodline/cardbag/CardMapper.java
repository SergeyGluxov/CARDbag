package info.goodline.cardbag;

import java.util.ArrayList;
import java.util.List;

public final class CardMapper {
    public static CardRealm map2Realm(Card card){
        CardRealm cardRealm = new CardRealm();
        cardRealm.setId(card.getId());
        cardRealm.setName(card.getName());
        cardRealm.setDiscount(card.getDiscount());
        cardRealm.setCategory(CategoryMapper.categoryMap2Realm(card.getCategory()));
        cardRealm.setPhoto(PhotoMapper.photoMap2Realm(card.getPhotos()));
        return cardRealm;
    }

    public static List<Card> map2DataList(List<CardRealm> realmList) {
        List<Card> cards = new ArrayList<>();
        for (CardRealm cardRealm : realmList) {
            Card card = new Card(
                    cardRealm.getId(),
                    cardRealm.getName(),
                    CategoryMapper.categoryMap2Date(cardRealm.getCategory()),
                    cardRealm.getDiscount(),
                    PhotoMapper.photoMap2Date(cardRealm.getPhoto())
            );
            cards.add(card);
        }
        return cards;
    }
}
