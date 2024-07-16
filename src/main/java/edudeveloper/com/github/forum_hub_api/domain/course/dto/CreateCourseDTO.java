package edudeveloper.com.github.forum_hub_api.domain.course.dto;

import jakarta.validation.constraints.NotBlank;
import edudeveloper.com.github.forum_hub_api.domain.course.Categories;

public record CreateCourseDTO(@NotBlank String name, Categories category) {

}
