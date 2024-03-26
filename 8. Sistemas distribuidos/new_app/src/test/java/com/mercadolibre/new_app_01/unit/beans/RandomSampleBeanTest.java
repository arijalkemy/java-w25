package com.mercadolibre.new_app_01.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.new_app_01.beans.RandomSampleBean;
import com.mercadolibre.new_app_01.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
