package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * {@link Account}のテストクラスです。
 */
public class AccountTest {

    // -------------------------------------------------------------
    // コンストラクタのテスト
    // -------------------------------------------------------------

    // ----------------- 正常系 ----------------- //

    @Test
    public void すべてのフィールドを初期化してnewできること() {
        Account a = new Account("Tom", 40000);
        assertEquals("Tom", a.getOwnerName());
        assertEquals(40000, a.getBalance());
    }

    // ----------------- 異常系 ----------------- //

    @Test(expected = IllegalArgumentException.class)
    public void 名義人にnullが設定された場合() {
        Account a = new Account(null, 100);
    }

    // @Test(expected = IllegalArgumentException.class)
    // public void 残高にマイナス金額が設定された場合() {
    //     Account a = new Account("Tom", -1);
    // }

    // -------------------------------------------------------------
    // 送金処理のテスト
    // -------------------------------------------------------------

    // ----------------- 正常系 ----------------- //

    @Test
    public void 送金処理で自分の残高が想定通り減少すること() {
        Account my = new Account("Me", 1000);
        Account dest = new Account("Dest", 2000);
        // 300円送金
        my.transfer(dest, 300);
        assertEquals(700, my.getBalance());
    }

    @Test
    public void 送金処理で相手の残高が想定通り増加すること() {
        Account my = new Account("Me", 1000);
        Account dest = new Account("Dest", 2000);
        // 300円送金
        my.transfer(dest, 300);
        assertEquals(2300, dest.getBalance());
    }

    // ----------------- 異常系 ----------------- //

    @Test(expected = IllegalArgumentException.class)
    public void 残高がマイナスになる金額を送金した場合() {
        Account my = new Account("Me", 1000);
        Account dest = new Account("Dest", 2000);
        // 1001円送金
        my.transfer(dest, 1001);
    }

    // -------------------------------------------------------------
    // 入金処理のテスト
    // -------------------------------------------------------------

    // ----------------- 正常系 ----------------- //

    @Test
    public void 入金処理が正常に行われること() {
        Account my = new Account("Me", 1000);
        // 1円入金
        my.deposit(1);
        assertEquals(1001, my.getBalance());
    }

    // ----------------- 異常系 ----------------- //

    @Test(expected = IllegalArgumentException.class)
    public void 入金額を0円とした場合() {
        Account my = new Account("Me", 1000);
        // 0円入金
        my.deposit(0);
    }

}
