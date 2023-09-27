package com.dongci777.im.common.model;

import com.dongci777.im.common.annotation.Sensitive;
import lombok.Data;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.lang.reflect.Field;

/**
 * @author: dongci777
 */
@Data
public abstract class BasePOJO {

    @Override
    public String toString() {
        String result = new ReflectionToStringBuilder(this, ToStringStyle.JSON_STYLE) {
            @Override
            protected Object getValue(Field field) throws IllegalArgumentException, IllegalAccessException {
                Sensitive sensitive = field.getAnnotation(Sensitive.class);
                if (sensitive != null) {
                    return sensitive.value().mask(String.valueOf(super.getValue(field)));
                }
                return super.getValue(field);
            }
        }.toString();

        // 修复 commons-lang3 3.8 起, 把中文转为 unicode 的问题
        //noinspection deprecation // 不想再加一个库 apache-common-text, 废弃方法先用着
        result = StringEscapeUtils.unescapeJava(result);

        return result;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

}
