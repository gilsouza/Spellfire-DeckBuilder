package br.com.gilsouza.spellfiredeckbuilder.dao;

import java.util.List;

import br.com.gilsouza.spellfiredeckbuilder.model.Card;

/**
 * Created by gilmar on 04/06/17.
 */

public interface ICardDAO {
    public Card fetchCardById(int cardId);
    public List<Card> fetchAllCards();
    public List<Card> fetchAllCardsBySpecs(Card cardEspecs);
}
