package com.mercadolibre.java_applications.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.java_applications.beans.RandomSampleBean;
import com.mercadolibre.java_applications.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
