class Twitter:

    def __init__(self):
        self.users = {}
        self.time = 0

    def __get(self, userid):
        if userid in self.users:
            return self.users[userid]
        else:
            self.users[userid] = [set([userid]), []]
            return self.users[userid]
        # self.users.get(userid, [set([userid]), []])

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.__get(userId)[1].append((-self.time, tweetId))
        self.time+=1

    def getNewsFeed(self, userId: int) -> List[int]:
        followees = self.__get(userId)[0]
        all_posts = [self.__get(i)[1] for i in followees]
        minhp = []
        
        for i,posts in enumerate(all_posts):
            if posts: heappush(minhp, (posts[-1],i, len(posts)-1))
        
        res = []
        
        while len(res)<10 and minhp:
            tweet, posts, pos = heappop(minhp)
            res.append(tweet[1])
            if pos>0:
                heappush(minhp, (all_posts[posts][pos-1], posts, pos-1))
                
        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        self.__get(followerId)[0].add(followeeId)
        
        
    def unfollow(self, followerId: int, followeeId: int) -> None:
        all_followee = self.__get(followerId)[0]
        if followeeId in all_followee:
            all_followee.remove(followeeId)
