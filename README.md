# 简介
尝试自己写个 RPC 库，力求小巧玲珑、简单易用，功能或高并发什么的暂且不想了。

# 设计说明
回归到通常的 Java API 调用风格，降低程序员的心智负担。我们调用 Java API 时一般只需要关注类、方法、参数、返回值以及可能的异常（也即过程、参数、返回值），相比之下 RPC 调用多了一个网络通信的过程，但这个过程对调用着来说是透明的，且网络通信中的各种问题都可抽象为异常抛出。基于此，调用 RPC 接口比普通的 Java API 只需多处理几种异常罢了。

上个小例子来描述一个 Java RPC 接口。
```java
/**
 * 账户服务
 */
class Session {}
interface AccountService {
	Session login(String username, String passwd) throws IOException, TimeoutException;
	void logout(Session session) throws IOException, TimeoutException;
}


/**
 * 战斗服务
 */
class Battle {}
class AttackResult {}
interface BattleService {
	Battle startFight(Session sessoin, Fitghtable fighter) throws IOException, TimeoutException;
	AttackResult attack(Session sessoin, Fitghtable fighter) throws IOException, TimeoutException;
}

```

# 特性
* 简单。
* 除了简单之外一无是处。

# Example
```bash
gradle run -DmainClass=example.Simple
```

# TODO:
* 实现
