/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* currentNode = new ListNode();
        ListNode* ans = currentNode;
        int first = l1->val;
        int second = l2->val;
        int third = 0;
        while(first + second + third > 0 || l1 || l2) {
            int curr = first + second + third;
            if(curr > 9) {
                third = curr/10;
                curr = curr%10;
            } else third = 0;
            currentNode->val = curr;
            if(l1)l1 = l1->next;
            first = l1 ? l1->val:0;
            if(l2)l2 = l2->next;
            second = l2 ? l2->val:0;
            if(first + second + third > 0 || l1 || l2) {
                currentNode->next = new ListNode();
                currentNode = currentNode->next;
            }
        }
        return ans;
    }
};