package hello.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemprice);   // 최종 order 결과 반환
}
