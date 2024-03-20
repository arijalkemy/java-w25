package com.ValentinCampestri.ObrasLiterarias.service;

import com.ValentinCampestri.ObrasLiterarias.dto.MessageDto;
import com.ValentinCampestri.ObrasLiterarias.dto.ObraLiterariaDto;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceObraLiteraria {
    MessageDto cargarObras(ObraLiterariaDto dto);
    MessageDto cargarObrasBatch(List<ObraLiterariaDto> listaNuevasObras);
    List<ObraLiterariaDto> traerTodas();
}
