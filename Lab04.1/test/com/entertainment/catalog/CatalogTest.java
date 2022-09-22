/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Map;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {
  
  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("RokuTV");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void testFindByBrandWithMatches(){
    Collection<Television> tvs = Catalog.findByBrand("Sony");
    assertNotNull(tvs);
    assertFalse(tvs.isEmpty());
    assertEquals(7, tvs.size());
  }

  @Test
  public void testFindByBrandsNoMatches(){
    Map<String,Collection<Television>> tvsMap = Catalog.findByBrands(); //we pass empty string[]
    assertNotNull(tvsMap);
    assertTrue(tvsMap.isEmpty());

    Map<String,Collection<Television>> tvsMap1 = Catalog.findByBrands("RokuTV", "Apple", "Samsung"); //pass 3 arguments that don't exist
    assertNotNull(tvsMap1);
    assertTrue(tvsMap1.isEmpty());
  }

  @Test
  public void testFindByBrandsMatches(){
    Map<String,Collection<Television>> tvsMap = Catalog.findByBrands("RCA", "Zenith", "Sony"); //pass 3 arguments that do exist
    assertNotNull(tvsMap);
    assertFalse(tvsMap.isEmpty());
    assertEquals(7, tvsMap.get("Sony").size());
    assertEquals(9, tvsMap.get("RCA").size());
    assertEquals(9, tvsMap.get("Zenith").size());
  }
}