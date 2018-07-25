package ua.com.un_th.http_url.data_containers;

import com.ebay.xcelite.annotations.AnyColumn;

import java.util.Map;
import java.util.Objects;

public class RequestNode {
    @AnyColumn
    private Map<String, Object> dynamicCols;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestNode that = (RequestNode) o;
        return Objects.equals(dynamicCols, that.dynamicCols);
    }

    @Override
    public int hashCode() {

        return Objects.hash(dynamicCols);
    }

    @Override
    public String toString() {
        return "RequestNode{" +
                "dynamicCols=" + dynamicCols +
                '}';
    }
}
