package com.javaw25.qatester.dto.response;

import com.javaw25.qatester.dto.TestCaseDto;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetTestCaseDto {
    List<TestCaseDto> testCaseList;
}
