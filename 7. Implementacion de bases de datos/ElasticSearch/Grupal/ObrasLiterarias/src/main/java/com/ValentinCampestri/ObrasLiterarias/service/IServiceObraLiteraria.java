package com.ValentinCampestri.ObrasLiterarias.service;

import com.ValentinCampestri.ObrasLiterarias.dto.MessageDto;
import com.ValentinCampestri.ObrasLiterarias.dto.ObraLiterariaDto;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public interface IServiceObraLiteraria {
    MessageDto cargarObras(ObraLiterariaDto dto);
}
