package com.javatunes.catalog;

import static org.junit.Assert.*;

import org.junit.Test;

public class InMemoryCatalogTest {

  @Test
  public void findById() {
    MusicItem actual = new InMemoryCatalog()
        .findById(14L);

    assertEquals("So", actual.getTitle());
    assertEquals("Peter Gabriel", actual.getArtist());
  }

  @Test
  public void findById_nonExist(){
    MusicItem found = new InMemoryCatalog().findById(Long.MAX_VALUE);
    assertNull(found);
  }
}