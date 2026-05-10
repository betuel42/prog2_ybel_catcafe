package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CatCafeTest {

  @Test
  void givenEmptyCafe_whenGetCatCount_thenReturnZero() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    long count = cafe.getCatCount();

    // then
    assertEquals(0, count);
  }

  @Test
  void givenOneCat_whenAddCat_thenCatCountIsOne() {
    // given
    CatCafe cafe = new CatCafe();
    FelineOverLord cat = new FelineOverLord("Milo", 4);

    // when
    cafe.addCat(cat);

    // then
    assertEquals(1, cafe.getCatCount());
  }

  @Test
  void givenMultipleCats_whenAddCats_thenCorrectCountReturned() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    cafe.addCat(new FelineOverLord("Milo", 4));
    cafe.addCat(new FelineOverLord("Luna", 3));
    cafe.addCat(new FelineOverLord("Leo", 5));

    // then
    assertEquals(3, cafe.getCatCount());
  }

  @Test
  void givenExistingCatName_whenGetCatByName_thenCorrectCatReturned() {
    // given
    CatCafe cafe = new CatCafe();
    FelineOverLord cat = new FelineOverLord("Milo", 4);
    cafe.addCat(cat);

    // when
    FelineOverLord result = cafe.getCatByName("Milo");

    // then
    assertEquals(cat, result);
  }

  @Test
  void givenUnknownCatName_whenGetCatByName_thenReturnNull() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    FelineOverLord result = cafe.getCatByName("Unknown");

    // then
    assertNull(result);
  }

  @Test
  void givenNullName_whenGetCatByName_thenReturnNull() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    FelineOverLord result = cafe.getCatByName(null);

    // then
    assertNull(result);
  }

  @Test
  void givenCatsWithinWeightRange_whenGetCatByWeight_thenReturnCorrectCat() {
    // given
    CatCafe cafe = new CatCafe();
    FelineOverLord cat = new FelineOverLord("Luna", 5);
    cafe.addCat(cat);

    // when
    FelineOverLord result = cafe.getCatByWeight(4, 6);

    // then
    assertEquals(cat, result);
  }

  @Test
  void givenNegativeMinWeight_whenGetCatByWeight_thenReturnNull() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    FelineOverLord result = cafe.getCatByWeight(-1, 5);

    // then
    assertNull(result);
  }

  @Test
  void givenMaxWeightSmallerThanMinWeight_whenGetCatByWeight_thenReturnNull() {
    // given
    CatCafe cafe = new CatCafe();

    // when
    FelineOverLord result = cafe.getCatByWeight(10, 5);

    // then
    assertNull(result);
  }

  @Test
  void givenNoCatInWeightRange_whenGetCatByWeight_thenReturnNull() {
    // given
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Leo", 10));

    // when
    FelineOverLord result = cafe.getCatByWeight(1, 5);

    // then
    assertNull(result);
  }
}
