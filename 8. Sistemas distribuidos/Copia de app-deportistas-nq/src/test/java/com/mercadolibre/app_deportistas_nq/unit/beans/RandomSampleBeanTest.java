package com.mercadolibre.app_deportistas_nq.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.app_deportistas_nq.beans.RandomSampleBean;
import com.mercadolibre.app_deportistas_nq.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

class RandomSampleBeanTest {

  @Test
  void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
